from flask import Flask, render_template, request, render_template_string, send_file
import re,os
def calculateStrength(name):
	strength = 0
	for _ in name:
		strength += ord(_)
	return str(strength)
def isAdmin():
	# We didn't implement this yet so no one is an admin
	return False
app = Flask('AAA')
app.secret_key=os.urandom(32)
@app.route('/',methods=['POST','GET'])
def index():
	if request.method == 'POST':
		if re.search("\{\{|\}\}|(popen)|(os)|(subprocess)|(application)|(getitem)|(flag.txt)|\.|_|\[|\]|\"|(class)|(subclasses)|(mro)",request.form['name']) is not None:
			name= "Hacking detected"
			return render_template("index.html", name=name,response="0")
		else:
			name = "Name : "+render_template_string(request.form['name'])
			response = "Strength : "+ calculateStrength(request.form['name'])
			if isAdmin():
				return render_template("index.html", name=name,  response=response)
			else:
				return render_template("index.html",name="Guest", response=response)
	if request.method == 'GET':
		return render_template("index.html")

@app.route("/source")
def get_source():
	return send_file("./main.py",as_attachment=True)

if __name__ == "__main__":
    app.run(host='0.0.0.0')
