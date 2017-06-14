//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private char[] vertexs;//顶点
    private int[][] matrixs;//邻接矩阵
    private int vexnum;//顶点数目
    private boolean[] visited;//是否被遍历到
    //初始化
    public Graph(int n) {
        this.vexnum = n;
        this.vertexs = new char[n];
        this.matrixs = new int[n][n];
        this.visited = new boolean[n];

        for(int i = 0; i < this.vexnum; ++i) {
            for(int j = 0; j < this.vexnum; ++j) {
                this.matrixs[i][j] = 0;
            }
        }

    }
    //添加边
    public void addEdge(int i, int j) {
        if(i != j) {
            this.matrixs[i][j] = 1;
            this.matrixs[j][i] = 1;
        }
    }

    public void setVertexs(char[] vertexs) {
        this.vertexs = vertexs;
    }

    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }
    //返回顶点i的第一个邻接点索引，如果失败则返回-1
    public int firstVertex(int i) {
        for(int j = 0; j < this.vexnum; ++j) {
            if(this.matrixs[i][j] == 1) {
                return j;
            }
        }

        return -1;
    }
    //返回顶点i相当于k顶点下一个顶点的连接关系，如果不存在连接的则返回-1
    public int nextVertex(int i, int k) {
        for(int j = k + 1; j < this.vexnum; ++j) {
            if(this.matrixs[i][j] == 1) {
                return j;
            }
        }

        return -1;
    }

    public void visit(int i) {
        System.out.print(this.vertexs[i] + " ");
    }
    //利用递归算法深度遍历图
    private void traverse(int i) {
        this.visited[i] = true;
        this.visit(i);

        for(int j = 0; j < this.vexnum; ++j) {
            if(this.matrixs[i][j] == 1 && !this.visited[j]) {
                this.traverse(j);
            }
        }

    }

    public void DFS() {
        int i;
        for(i = 0; i < this.vexnum; ++i) {
            this.visited[i] = false;
        }

        for(i = 0; i < this.vexnum; ++i) {
            if(!this.visited[i]) {
                this.traverse(i);
            }
        }

    }
    //广度优先遍历
    public void BFS() {
        Queue<Integer> q = new LinkedList();

        int i;
        for(i = 0; i < this.vexnum; ++i) {
            this.visited[i] = false;
        }

        for(i = 0; i < this.vexnum; ++i) {
            if(!this.visited[i]) {
                q.add(Integer.valueOf(i));
                this.visited[i] = true;
                this.visit(i);

                while(!q.isEmpty()) {
                    int j = ((Integer)q.remove()).intValue();
                    //从j点的第一个邻接点开始,一直遍历与j相连的顶点
                    for(int k = this.firstVertex(j); k >= 0; k = this.nextVertex(j, k)) {
                        if(!this.visited[k]) {
                            q.add(Integer.valueOf(k));
                            this.visited[k] = true;
                            this.visit(k);
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph g1 = new Graph(7);
        char[] vertexs = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        g1.setVertexs(vertexs);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(0, 6);
        g1.addEdge(1, 2);
        g1.addEdge(1, 5);
        g1.addEdge(2, 4);
        g1.addEdge(4, 5);
        g1.addEdge(4, 3);
        System.out.print("深度优先遍历");
        g1.DFS();
        System.out.print("广度优先遍历");
        g1.BFS();
    }
}
