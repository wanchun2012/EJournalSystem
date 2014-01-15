<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="submit-next" class="leaderboard">
	<h3>Submit an Article</h3>
	<p>	How to submit an article guide</p>
	<hr/>
	<div style="margin-top:10px" class="row-fluid">
		<div class="accordion" id="accordion2">
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion2" href="#collapseOne"> Guidelines </a>
				</div>
				<div id="collapseOne" class="accordion-body collapse"
					style="height: 0px;">
					<div class="accordion-inner">
					<!-- ref page: http://www.contempaesthetics.org/pages/guidelines.html -->
					<p>
					Articles for submission must be previously unpublished
					 and in English. Papers should be well-written, and we encourage grace as well as 
					 clarity. It is important that papers be copy-edited carefully before submission. 
					 Drafts are not acceptable. In order to ensure diversity of subject matter, 
					 approaches, and voices, papers by authors who have not published in 
					 TeamOEJournal for at least a year prior to submission are normally 
					 given precedence. In submitting work to TeamOEJournal, authors agree 
					 to the policies of this journal, including free access and use of the material 
					 published in it with, of course, proper acknowledgment of authorship and source. 
					 If you have any questions about whether your article is appropriate for TeamOEJournal, send 
					 it directly to the editor for a preliminary review. 
					 </p><p>
All articles will be blind-refereed except when invited. The decision of the editorial board is final. 
Articles accepted for publication will be copyrighted by TeamOEJournal. 
Because TeamOEJournal relies on the generosity of scholars who contribute their time to review 
articles, we ask that authors not submit their work to other journals at the same time. By using computer 
technology throughout, we expect that the review process will move quickly and that authors will be notified 
in a reasonable time. In sending work to TeamOEJournal for possible publication, the submitter 
attests that the work is original and that he or she is the author, that it has not been published, and that 
it is not under consideration for publication elsewhere. 
</p>
	</div>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion2" href="#collapseTwo"> How to submit </a>
				</div>
				<div id="collapseTwo" class="accordion-body collapse">
					<div class="accordion-inner">
<p>
Our submission guidelines have been carefully prepared to facilitate the editorial process of publishing articles online. Strict adherence to formatting guidelines (described below) has three purposes. First, consistent and uniform formatting allows the editors and reviewers to concentrate on the content of articles submitted. Second, it allows for reliable translation of authors' formatting to the web page. The third consideration is both aesthetic and practical: multiple stylistic formats are ugly and distracting on a web page and interfere with reading. Therefore, please observe the following formatting instructions carefully. Submissions which do not adhere to these instructions will be returned to the author.
</p><p>
Formatting the Article
</p><p>
The article should be prepared according to the following guidelines: 
</p><p>
(1) The length of articles is normally no greater than 5,000 words but should not exceed 7,000 words, including an abstract and notes. An article exceeding the length limit will be returned to the author. 
</p><p>
(2) At the beginning of the article, the title, abstract and a list of key words should immediately precede the text. Do not include the author's name or any other identifying information. Any identifying reference in the endnotes should be left blank.
</p><p>
(3) Please use section headings in bold type and number them. Because TeamOEjournal uses no page numbers, numbered sections will permit accurate references in citing the article.
</p><p>
(4) All citations should be in endnotes and not in the text. Number endnotes sequentially with Arabic numbers. Use the endnote function in your word processing program so that the notes appear at the end of the article. 
</p><p>
(5) References should conform to the style displayed in the samples below under Citations and References. 
</p><p>
(6) Font should be 11-point Arial, whether in normal, bold, or italic, including endnotes. Please do not insert line breaks in the text or special spacing for formatting.
</p><p>
(7) The paragraph break should be indicated by an extra line space rather than an indentation at the beginning of a paragraph. 
</p><p>
(8) Only the left hand margin should be justified. 
</p><p>
Citations and References
</p><p>
References in articles submitted to TeamOEjournal should conform to the formats below. For references that do not fit these forms, please follow the Chicago documentation style. There are several online sources for this showing endnote citation and reference list forms. See, for example, http://www.bridgew.edu/library/turabian.htm.
</p><p>
Wolfgang Welsch, Undoing Aesthetics (London: Sage, 1997), pp. 5-7.
</p><p>
Yi-Fu Tuan, "Place: An Experiential Perspective," The Geographical Review, 65, 2 (1975), 148-155; ref. on 151.
</p><p>
T. Coraghessan Boyle, "Greasy Lake," in The Granta Book of the American Short Story, ed. Richard Ford (London: Granta Books, 1993), pp. 555-561; ref.on p. 555.
</p><p>
Please do not include a bibliography. Citations in the endnotes should supply all pertinent information.
</p>				
					</div>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion2" href="#collapseThree"> Download
						Template </a>
				</div>
				<div id="collapseThree" class="accordion-body collapse">
					<a
						href="<c:url value="/resources/template/IS12_paper_template.pdf" />"
						style="margin: 1px 10px 5px" class="btn btn-warning btn-small"><i
						class="icon-white icon-download-alt"></i>PDF</a> <a
						href="<c:url value="/resources/template/IS12_paper_template.doc" />"
						style="margin: 1px 10px 5px" class="btn btn-warning btn-small"><i
						class="icon-white icon-download-alt"></i>Doc</a> <a
						href="<c:url value="/resources/template/IS12_paper_template.tex" />"
						style="margin: 1px 10px 5px" class="btn btn-warning btn-small"><i
						class="icon-white icon-download-alt"></i>LaTeX</a>

				</div>

			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
					<a id="expand-form" class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion2" href="#collapseFour"> Article Submission
						Form </a>
				</div>
				<div id="collapseFour" class="accordion-body collapse">
					<%@ include file="art-submission-form.jsp"%>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$("#expand-form").click(function() {
		$('html, body').animate({
			scrollTop : $("#submit-paper").offset().top - 50
		}, 500);
	});
</script>
