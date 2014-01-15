<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN"
 "http://www.w3.org/TR/html4/strict.dtd">
 <html lang="en" dir="ltr">
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
   <title>JavaScript Textarea Example</title>
   <script type="text/javascript"><!--
    var wordLen = 20; // Maximum word length
     function checkWordLen(obj){
      var len = obj.value.split(/[\s]+/);
       if(len.length > wordLen){
           alert("You cannot put more than "+wordLen+" words in this text area.");
           obj.oldValue = obj.value!=obj.oldValue?obj.value:obj.oldValue;
           obj.value = obj.oldValue?obj.oldValue:"";
           return false;
       }
     return true;
   }
   //--></script>
  </head>
  <body>
   <h1>JavaScript Example</h1>
    <p>This JavaScript sets a maximum word count to a textarea.</p>
   <form action="" method="get"><fieldset>
    <legend>Example Form</legend>
     <label>Text input: <br><textarea rows="15" cols="30" name="t1" onchange="checkWordLen(this);"></textarea></label>
   </fieldset></form>
  </body>
 </html>
 