package kr.co.hf.domain;
import kr.co.hf.domain.ComVO;

public class ComVO {
    private int commentID;
    private int postID;
    private String commentAuthor;
    private String commentContent;
    
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getCommentAuthor() {
		return commentAuthor;
	}
	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	@Override
	public String toString() {
		return "ComVO [commentID=" + commentID + ", postID=" + postID + ", commentAuthor=" + commentAuthor
				+ ", commentContent=" + commentContent + "]";
	}
	
	
	
}