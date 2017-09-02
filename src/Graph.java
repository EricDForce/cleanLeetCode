public class Graph {

    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private int nTree;
    private DistPar sPath[];
    private int currentVert;
    private int startToCurrent;

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = INFINITY;
            }
        }
        sPath = new DistPar[MAX_VERTS];
    }

    public void addVertex(char lab){
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start,int end,int weight){
        adjMat[start][end] = weight;
    }

    public void path(){
        int startTree = 0;
        vertexList[startTree].isInTree = true;
        nTree = 1;
        for (int i = 0; i < nVerts; i++) {
            int tempDist = adjMat[startTree][i];
            sPath[i] = new DistPar(startTree, tempDist);
        }
        while(nTree < nVerts){
            int indexMin = getMin();
            int minDist = sPath[indexMin].distance;

            if(minDist == INFINITY){
                System.out.println("There are unreachable vertices");
                break;
            }
            else{
                currentVert = indexMin;
                startToCurrent = sPath[indexMin].distance;
            }
            vertexList[currentVert].isInTree = true;
            nTree++;
            adjust_sPath();
        }
        displayPaths();
        nTree = 0;
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].isInTree = false;
        }
    }

    public int getMin(){
        int minDist = INFINITY;
        int indexMin = 0;

        for (int i = 0; i < nVerts; i++) {
            if(!vertexList[i].isInTree && sPath[i].distance < minDist){
                minDist = sPath[i].distance;
                indexMin = i;
            }
        }
        return indexMin;
    }

    public void adjust_sPath(){
        int column = 1;
        while(column < nVerts){
            if(vertexList[column].isInTree){
                column++;
                continue;
            }
            int currentToFringe = adjMat[currentVert][column];
            int startToFringe = startToCurrent + currentToFringe;
            int sPathDist = sPath[column].distance;

            if(startToFringe < sPathDist){
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }
    }

    public void displayPaths(){
        for (int i = 0; i < nVerts; i++) {
            System.out.println(vertexList[i].label + " = ");
            if(sPath[i].distance == INFINITY)
                System.out.println("int");
            else
                System.out.println(sPath[i].distance);
            char parent = vertexList[sPath[i].parentVert].label;
            System.out.println("("+parent+")");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(0, 1, 50);
        theGraph.addEdge(0, 3, 80);
        theGraph.addEdge(1, 2, 60);
        theGraph.addEdge(1, 3, 90);
        theGraph.addEdge(2, 4, 40);
        theGraph.addEdge(3, 2, 20);
        theGraph.addEdge(3, 4, 70);
        theGraph.addEdge(4, 1, 50);

        System.out.println("shortest paths");
        theGraph.path();
        System.out.println();
    }
}