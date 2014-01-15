
	<form method="post" id="submit-paper" class="form-horizontal">
		<fieldset>
			<legend style="padding-left:20px"> Personal Data</legend>
			<div class="control-group">
				<label class="control-label" for="name">Name</label>
				<div class="controls">
					<input data-validate="submit" type="text" class="input-xlarge"
						id="name" />
				</div>

			</div>
			
			<div class="control-group">
				<label class="control-label" for="surname">Surname</label>
				<div class="controls">
					<input data-validate="submit" type="text" class="input-xlarge"
						id="surname" />
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="email">Email address</label>
				<div class="controls">
					<input data-validate="submit" type="email" class="input-xlarge"
						id="email" />
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="affiliation">Affiliation</label>
				<div class="controls">
					<input data-validate="submit" type="text" class="input-xlarge"
						id="affiliation" />
				</div>
			</div>
			<legend style="padding-left:20px"> Paper Data</legend>
			<div class="control-group">
				<label class="control-label" for="paper-title">Title</label>
				<div class="controls">
					<input data-validate="submit" type="text" class="input-xlarge"
						id="paper-title" />
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="keywords">Keywords</label>
				<div class="controls">
					<input data-validate="submit" type="text" class="input-xlarge"
						id="keywords" />
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="textarea">Abstract</label>
				<div class="controls">
					<textarea class="input-xlarge" id="abstract" rows="3"></textarea>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="fileInput">File</label>
				<div class="controls">
					<input class="input-file" id="fileInput" type="file">
				</div>
			</div>

			<div class="form-actions">
				<button type="submit" class="btn btn-primary">Submit</button>
				<button class="btn">Cancel</button>
			</div>
		</fieldset>
	</form>