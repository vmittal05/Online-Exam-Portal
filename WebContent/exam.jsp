<html><head>
<script>
<!--
<%
String clock = "100";
%>
var timeout = <%=clock%>;
function timer()
{
if( --timeout > 0 )
{
document.forma.clock.value = timeout;
window.setTimeout( "timer()", 1000 );
}
else
{
document.forma.clock.value = "Time over";
///disable submit-button etc
document.forma.submit();
}
}
//-->
</script>
<body bgcolor="lightskyblue">
<form action="./result" method="post" name="forma">
Seconds remaining: <input type="text" name="clock" value="<%=clock%>" style="border:0px solid white">
...
<br><br>
 <ol>
 <li>                
<h3>Which of the following is not a Java features?</h3>                   
<input type="radio" name="q1" id="qus" value="A" />
<label for="q1-A">A) Dynamic </label>                  
<input type="radio" name="q1" id="q1-B" value="B" />
<label for="q1-B">B) Architecture Neutral</label>                   
<input type="radio" name="q1" id="q1-C" value="C" />
<label for="q1-C">C) Use of pointers</label>                    
<input type="radio" name="q1" id="q1-D" value="D" />
<label for="q1-D">D) Object-oriented</label>                
</li>
                
<li>                
<h3>_____ is used to find and fix bugs in the Java programs.</h3>                    
<input type="radio" name="q2" id="q2-A" value="A" />
<label for="q2-A">A) JVM</label>                    
<input type="radio" name="q2" id="q2-B" value="B" />
<label for="q2-B">B) JRM</label>
<input type="radio" name="q2" id="q2-C" value="C" />
<label for="q2-C">C) JDK</label>
<input type="radio" name="q2" id="q2-D" value="D" />
<label for="q2-D">D) JDB</label>                
</li>
                
<li>
<h3>Which keyword is used for accessing the features of a package?</h3>                    
<input type="radio" name="q3" id="q3-A" value="A" />
<label for="q3-A">A) package</label>
<input type="radio" name="q3" id="q3-B" value="B" />
<label for="q3-B">B) import</label>                    
<input type="radio" name="q3" id="q3-C" value="C" />
<label for="q3-C">C) extends</label>                    
<input type="radio" name="q3" id="q3-D" value="D" />
<label for="q3-D">D) export</label>                
</li>                

<li>                
<h3>What is the default value of Boolean variable?</h3>                    
<input type="radio" name="q4" id="q4-A" value="A" />
<label for="q4-A">A) true</label>
<input type="radio" name="q4" id="q4-B" value="B" />
<label for="q4-B">B) false</label>
<input type="radio" name="q4" id="q4-C" value="C" />
<label for="q4-C">C) null</label>
<input type="radio" name="q4" id="q4-D" value="D" />
<label for="q4-D">D) not defined</label>                
</li>

<li>                
<h3>In java, jar stands for_____</h3>                    
<input type="radio" name="q5" id="q5-A" value="A" />
<label for="q5-A">A) Java ARchive</label>
<input type="radio" name="q5" id="q5-B" value="B" />
<label for="q5-B">B) Java Application Resource</label>
<input type="radio" name="q5" id="q5-C" value="C" />
<label for="q4-C">C) Java Application Runner</label>
<input type="radio" name="q5" id="q5-D" value="D" />
<label for="q5-D">D) None of the above</label>                
</li>  
                
</ol>
<input type="submit" value="Submit Quiz"/>

</form>
<script>
<!--
timer();
//-->
</script>
</body></html>
