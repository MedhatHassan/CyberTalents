from flask import Flask, render_template, request, render_template_string, send_file
import os, logging, re

logging.basicConfig(level=logging.DEBUG)

def calculateStrength(name):
    #Calculate strength as the sum of ASCII values of characters
    return str(sum(ord(c) for c in name))

def isAdmin():
    return False

app = Flask(__name__)
app.secret_key = os.urandom(32)

# Regex of the original CTF
PATTERN = re.compile(r"\{\{|\}\}|(popen)|(os)|(subprocess)|(application)|(getitem)|"
                             r"(flag.txt)|\.|_|\[|\]|\"|(class)|(subclasses)|(mro)")

@app.route('/', methods=['POST', 'GET'])
def index():
    if request.method == 'POST':
        user_input = request.form['name']
        logging.info(f"User Input: {user_input}")

        if PATTERN.search(user_input):
            logging.warning("Blocked input detected!")
            return "Hacking detected", 400  # Simulate security response

        try:
            rendered_output = render_template_string(user_input)
            name = "Name : " + rendered_output
            response = "Strength : " + calculateStrength(user_input)

            # Save output details to static/output.txt for debugging
            output_content = (
                f"User Input: {user_input}\n"
                f"Rendered Output: {rendered_output}\n"
                f"Final Name Variable: {name}\n"
                f"Strength Calculation: {response}\n"
            )

            with open("static/output.txt", "w") as f:
                f.write(output_content)

            logging.info("Output saved to static/output.txt")
            return render_template("index.html", name=name, response=response)

        except Exception as e:
            logging.error(f"Error: {e}")
            return "Error in processing", 500

    return render_template("index.html")

if __name__ == "__main__":
    app.run(debug=True)
