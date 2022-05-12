package kr.co.hf.domain;

public class BoardButtonDTO {
       private int boardCount;
       private int currentPage;
       private int totalPages;
       private int startPage;
       private int endPage;

       public BoardButtonDTO(int boardCount,int currentPage){
           this.boardCount = boardCount;
           this.currentPage = currentPage;

           if(this.boardCount == 0) {
			// 아래에 깔리는 버튼 자체가 없어야함.
			this.totalPages = 0;
			this.startPage = 0;
			this.endPage = 0;
		}else {

            if(boardCount % 10 == 0) {
               this.totalPages = this.boardCount / 10;
			}else {
                  this.totalPages = (this.boardCount/10)+1;
         }

         int navNum = 0;

         navNum = (currentPage - 1) / 10;
         this.endPage = navNum + (10 - 1);

         if(this.totalPages < this.endPage) {
				this.endPage = this.totalPages;
			}
        }
        

    }
    public int getBoardCount() {
		return boardCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	@Override
	public String toString() {
		return "BoardButtonDTO [boardCount=" + boardCount + ", currentPage=" + currentPage + ", totalPages="
				+ totalPages + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
}
