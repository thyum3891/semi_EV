package com.kh.semi.vo;

public class Faq {
	String title;
	String contents;

	public Faq() {
		super();
	}

	public Faq(String title, String contents) {
		super();
		this.title = title;
		this.contents = contents;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Faq [title=" + title + ", contents=" + contents + "]";
	}

}
