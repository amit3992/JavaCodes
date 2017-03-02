package mergingTables;

class Table {
	
    Table parent;
    int rank;
    int numberOfRows;
    int nodeNum;

    Table(int nodeNum, int numberOfRows) {
        this.numberOfRows = numberOfRows;
        this.nodeNum = nodeNum;
        rank = 0;
        parent = this;
    }
    
}