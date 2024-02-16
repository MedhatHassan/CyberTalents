import base64
import re

def remove_unwanted_chars(flag):
    # Use a regular expression to keep only alphanumeric characters
    cleaned_flag = re.sub(r'[^a-zA-Z0-9]', '', flag)
    return cleaned_flag

flag = "&^&@|* Zm}&,);\\(\'))[\\[$`|_^#(x*]>&hZ)\'$ $#(: [$3;&$t \\_\']?&>,&i)!QG{`- ,% ~<`._@\'::_\\_{}- |_[&{<`~$) ?\'?(!$,.{>? @!^:#|R,?\')`[,`;?!f_:$$<)Y}$:[|^?2)_h&><.:.-{&[|&A\\*;*)-($.>>(<^\';#Q@?, ,H\\`|)$ <):@(;}?-[~(&)>>*)(~)`$:[;>!.&%<!.>~ %J}*zX:(&:~:<0)*>(B(!?.#@A*<*{-,[Q@{%!~)~-~:@:#|![>) ]?];H;$-<}>!@~)<<) \\_!|]#,&!,@>\\[]|J ]\\^[?>$|$?\'|,#.)$l[^@X.~! \\;0-&,;,![\'@[J*~#`AQ[*&%<,~]? ~_^~(;}\\$>)[&@) (]}];;*^<)\'\'@\\E[.@! B*.<-A-,:-#`-.}<-|)^Z@](?;H >-}.%.?}@<!())0] <&=@(<*$\\(("
flag = remove_unwanted_chars(flag)
print("Flag encoded base64 : ",flag)
# decode the flag base64 Note that flag is missing padding so we added '='
res_bytes = base64.b64decode(flag + "=")
# Convert the decoded bytes to a string
res = res_bytes.decode('utf-8')
print("Flag : ",res)