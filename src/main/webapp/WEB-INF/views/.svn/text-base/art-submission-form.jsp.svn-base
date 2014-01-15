
<!-- javascript to add authors dynamically -->
<script type="text/javascript">
	var authcounter = 1;
	var authLimit = 5;
	function addInput(divName) {
		if (authcounter == authLimit) {
			
			//CREATE POPUPPP alert
			
			alert("Max " + authcounter + " Authors");
			createAutoClosingAlert(".alert-warning", "Max " + authcounter + " Authors");
		} else {
			authcounter++;
			var newdiv = document.createElement('div');
			newdiv.innerHTML = '<hr/> <div id="author_'+authcounter+'"> <p style="padding-left:10px">Author ' + (authcounter)+   '</p>' +
			' <div class="control-group"> <label class="control-label" for="firstname">First Name	</label> <div class="controls"> <input data-validate="submit" type="text"   id="firstname_'+authcounter+'"  name="firstname_'+authcounter+'" />	</div>	</div>'+
			' <div class="control-group"> <label class="control-label" for="secondname">Second Name	</label> <div class="controls"> <input data-validate="submit" type="text"   id="secondname_'+authcounter+'" name="secondname_'+authcounter+'" />	</div> </div>'+
			' <div class="control-group"> <label class="control-label" for="email">   Email address	</label> <div class="controls"> <input data-validate="submit" type="email"  id="email_'+authcounter+'"  	name="email_'+authcounter+'"/>	</div> </div>'+
			' <div class="control-group"> <label class="control-label" for="affiliation">Affiliation</label> <div class="controls">	<input data-validate="submit" type="text"   id="affiliation_'+authcounter+'"name="affiliation_'+authcounter+'" /> </div> </div> </div>';
			document.getElementById(divName).appendChild(newdiv);
		}

		// give focus to the newly added input
		$('html, body').animate({
			scrollTop : $("#author_" + authcounter).offset().top -90
		}, 500);
	}
</script>


<!-- javascript to submit form -->
<script type="text/javascript">

	var abstLenIsFine = false;
	var wordLen = 250; // Maximum word length
	
	var authorInfo = "";
	function validateAuthor(){
		authorInfo = "";
		var valid = true;
		if ($("#firstname_1").val() == "") {
			authorInfo += "\nEmpty first name";
			valid = false;
		}
		if ($("#secondname_1").val() == "") {
			authorInfo += "\nEmpty second name";
			valid = false;
		}
		if ($("#email_1").val() == "") {
			authorInfo += "\nEmpty email field";
			valid = false;
		}
		if ($("#affiliation_1").val() == "") {
			authorInfo += "\nEmpty affiliation field";
			valid = false;
		}
		return valid;
	}
	
	var paperProblems = "";
	function validatePaper(){
		paperProblems = "";
		var valid = true; 
		if ($("#paper-title").val() == "") {
			paperProblems += "\nEmpty paper title";
			valid = false;
		}
		if ($('#keywords').tagify('serialize').split(",").length <= 1) {
			paperProblems += "\nNo keywords";
			valid = false;
		}
		if (!abstLenIsFine) {
			paperProblems += "\nAbstract empty or too long, max "+wordLen+" words";
			valid = false;
		}	
		if (typeof($("#fileInput")[0].files[0]) == "undefined") {
			paperProblems += "\nFile missing";
			valid = false;
		}
		return valid;
	}

	function checkWordLen(obj){
		var len = obj.value.split(/[\s]+/);
	    if(len.length > wordLen){
	    	alert("Abstract cannot be longer than "+wordLen+" words.");
	        obj.oldValue = obj.value!=obj.oldValue?obj.value:obj.oldValue;
	        obj.value = obj.oldValue?obj.oldValue:"";
	        abstLenIsFine = false;
	        return false;
	    }
	    if (len.legth < 1){
	    	abstLenIsFine = false;
	    	return false;
	    }
	    abstLenIsFine = true;
	   	return true;
	}
	
	//check words dynamically
	function checkWordLen(obj){
		var len = obj.value.split(/[\s]+/);
	    if(len.length > wordLen){
	    	alert("Abstract cannot be longer than "+wordLen+" words.");
	        obj.oldValue = obj.value!=obj.oldValue?obj.value:obj.oldValue;
	        obj.value = obj.oldValue?obj.oldValue:"";
	        abstLenIsFine = false;
	        return false;
	    }
	    if (len.legth < 1){
	    	abstLenIsFine = false;
	    	return false;
	    }
	    abstLenIsFine = true;
	   	return true;
	}
	
	//submit form
	$("#btnArtSubmit").click(function() {
		if (!validateAuthor()) {
			alert("Validation error: "+authorInfo);
		} else if (!validatePaper()) {
			alert("Validation error: "+paperProblems);
		} else {
			var article = {
					title 			: $("#paper-title").val(),
					keywords 		: $('#keywords').tagify('serialize').split(","),
					paperAbstract   : $("#abstract").val(),   
					authors	 		: []
				};
	
			for(var i =1; i<= $('[id^=author]').length; i++) {
			    article.authors.push({ 
			        "firstname" 	: $('#firstname_'+i).val(),
			        "secondname"  	: $('#secondname_'+i).val(),
			        "email"     	: $('#email_'+i).val(),
			        "affiliation"	: $('#affiliation_'+i).val()
			   });		
			}
			
		    var file = $("#fileInput")[0].files[0];
			
			function failFILE(data){
				$("#main-content").load($('#contentRef').attr('base-ref')+"upload-outcome-fail-file",function(){
					alert(data.args[0]);
					$("#error-data").text(data.args[0]);
				});
			}
			
			function failJSON(data){
				$("#main-content").load($('#contentRef').attr('base-ref')+"upload-outcome-fail-json", function(){
					alert(data.args[0]);
					$("#error-data").text(data.args[0]);
				});
			}
			
			function completedFILE(data){
				$.postJSON($("#file-vars-refs").attr('submit-ref-vars'),article,completedJSON,failJSON);		
			}
			
			function completedJSON(data){
				$("#main-content").load($('#contentRef').attr('base-ref')+"upload-outcome-success");
			}
			
			$.postFILE($("#file-vars-refs").attr('submit-ref-file'),file,completedFILE,failFILE);
		}
			return false;
	});
</script>

<span id="file-vars-refs" style="display: none" 
	submit-ref-file="<c:url value="/submit_article_file"/>"
	submit-ref-vars="<c:url value="/submit_article_vars"/>"></span>
<form method="post" id="submit-article" class="form-horizontal">
	<fieldset>
		<legend style="padding-left: 20px"> Author/s Data</legend>
		<div>
			<div id="dynamicInput">
				<div id="author_1">
					<p style="padding-left: 10px">Author 1 (main contact)</p>
					<div class="control-group">
						<label class="control-label" for="firstname">First Name</label>
						<div class="controls">
							<input class="input-xlarge" data-validate="submit" type="text" id="firstname_1"
								name="firstname_1" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="secondname">Second Name</label>
						<div class="controls">
							<input class="input-xlarge" data-validate="submit" type="text" id="secondname_1"
								name="secondname_1" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="email">Email address</label>
						<div class="controls">
							<input class="input-xlarge" data-validate="submit" type="email" id="email_1"
								name="email_1" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="affiliation">Affiliation</label>
						<div class="controls">
							<input class="input-xlarge" data-validate="submit" type="text" id="affiliation_1"
								name="affiliation_1" />
						</div>
					</div>
				</div>
			</div>
			<div style="margin-left: 10px">
				<input class="btn btn-primary" type="button"
					value="Add another author" onClick="addInput('dynamicInput');">
			</div>
			<hr/>
		</div>

		<legend style="padding-left: 20px"> Article Data</legend>
		<div class="control-group">
			<label class="control-label" for="paper-title">Title</label>
			<div class="controls">
				<input class="input-xlarge" placeholder="title" data-validate="submit" type="text"
					id="paper-title" name="paper-title" />
			</div>
		</div>

		<script type="text/javascript"
			src="<c:url value="/resources/js/jquery.tagify.js" />"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script type="text/javascript">	

			$('#keywords').tagify({
				delimiters: [13, 188],
				cssClass: 'tagify-container'
			}); 
		</script>

		<div class="control-group">
			<label class="control-label" for="keywords">Keywords <br>(type keyword and press enter to add)</label>
			<div class="controls">
				<textarea class="input-xlarge tagify-container" data-validate="submit"
					id="keywords" name="keywords"></textarea>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="textarea">Abstract</label>
			<div class="controls">
				<textarea class="input-xlarge" placeholder="max 250 words" id="abstract" name="abstract"
					rows="3"  onchange="checkWordLen(this);"></textarea>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="fileInput">File</label>
			<div class="controls">
				<input class="input-xlarge" class="input-file" id="fileInput" name="fileInput"
					type="file">
			</div>
		</div>

		<div class="form-actions">
			<button id="btnArtSubmit" type="submit" class="btn btn-primary">Submit</button>
		</div>
	</fieldset>
</form>