<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- javascript to submit form -->
<script type="text/javascript">
$("#update-journal-settings-btn").click(
function() {
		var settings = {
			journalTitle : $("#journal-title").val(),
			aimsAndGoals : $("#aims-and-goals").val(),
		};

		//var file = $("#fileInput")[0].files[0];

		function failFILE(data) {
			$("#main-content").load($('#contentRef').attr('base-ref')+ "updatesettings-outcome-fail-file");
		}

		function failJSON(data) {
			$("#main-content").load($('#contentRef').attr('base-ref')+ "updatesettings-outcome-fail-json");
			$("#error-data").text(data.args[0]);
		}

		function completedFILE(data) {
			$.postJSON("update_journal_settings", settings, completedJSON,failJSON);
		}

		function completedJSON(data) {
			alert($('#contentRef').attr('base-ref')+ "updatesettings-outcome-success");
			$("#main-content").load($('#contentRef').attr('base-ref')+ "updatesettings-outcome-success");
		}

		//$.postFILE("submit_template_file", file, completedFILE,failFILE);
		$.postJSON($("#settings-vars-refs").attr('submit-settings-vars'), settings, completedJSON,failJSON);
		return false;

	});
</script>
<span id="settings-vars-refs" style="display: none" 
	submit-settings-vars="<c:url value="/setup_journal"/>"></span>
<form method="post" id="update-journal-settings" class="form-horizontal">
	<fieldset>
		<legend>Journal Settings</legend>
		<div class="control-group">
			<label class="control-label" for="journal-title">Title</label>
			<div class="controls">
				<input data-validate="submit" type="text" class="input-xxlarge"
					id="journal-title" value="${journalSettings.title}" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="aims-and-goals">Academic
				Aims and Goals</label>
			<div class="controls">
				<textarea class="input-xxlarge" id="aims-and-goals" rows="5">${journalSettings.academicGoals}</textarea>
			</div>
		</div>
		
		<!--
		<div class="control-group">
			<label class="control-label" for="template-format">Template
				Format</label>
			<div class="controls">
				<select class="input-xxlarge" id="template-format"
					name="template-format">
					<option value="pdf">PDF</option>
					<option value="doc">Doc</option>
					<option value="latex">LaTeX</option>
				</select>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="fileInput">Upload Template</label>
			<div class="controls">
				<input id="fileInput" type="file">
			</div>
		</div>-->

		
	</fieldset>
</form>

<button id="update-journal-settings-btn" 
				class="btn btn-primary">Update Settings</button>

