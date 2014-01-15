package com.teamo.ejournal.core.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EditorAddEmail {
	
	@Email
	@NotEmpty
	private String editorEmail;

	public EditorAddEmail() {
	}

	public String getEditorEmail() {
		return editorEmail;
	}

	public void setEditorEmail(String editorEmail) {
		this.editorEmail = editorEmail;
	}

	@Override
	public String toString() {
		return "EditorAddEmail [editorEmail=" + editorEmail + "]";
	}
	
}
