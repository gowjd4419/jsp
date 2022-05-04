package kr.co.hf.domain;


public class RankVO {
	private int rankID;
	private int postID;
    private int rankPosition;
	
	
	@Override
	public String toString() {
		return "PreviewVO [rankID=" + rankID + ", postID=" + postID + ", rankPosition=" + rankPosition + "]";
	}


	public int getRankPosition() {
		return rankPosition;
	}


	public void setRankPosition(int rankPosition) {
		this.rankPosition = rankPosition;
	}


	public int getPostID() {
		return postID;
	}


	public void setPostID(int postID) {
		this.postID = postID;
	}


	public int getRankID() {
		return rankID;
	}


	public void setRankID(int rankID) {
		this.rankID = rankID;
	}
}