package kr.co.hf.domain;


public class LikeVO {
	private int likeID;
	private int postID;
    private int likeType;
    private int userID;
	
	
	@Override
	public String toString() {
		return "PreviewVO [likeID=" + likeID + ", postID=" + postID + ", userID=" + userID + ", likeType=" + likeType + "]";
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public int getPostID() {
		return postID;
	}


	public void setPostID(int postID) {
		this.postID = postID;
	}


	public int getLikeType() {
		return likeType;
	}


	public void setLikeType(int likeType) {
		this.likeType = likeType;
	}

    public int getLikeID() {
		return likeID;
	}


	public void setLikeID(int rankID) {
		this.likeID = likeID;
	}
}