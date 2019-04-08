import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Graph graph = new Graph();
		
		// Partie 1: A completer : Création du graphe
		Node A = new Node('A',"A");
		Node B = new Node('B',"B");
		Node C = new Node('C',"C");
		Node D = new Node('D',"D");
		Node E = new Node('E',"E");
		Node F = new Node('F',"F");
		Node G = new Node('G',"G");
		//on ajoute les noeuds dans la liste.
		List<Node> asNlist = Arrays.asList(A,B,C,D,E,F,G);
		List<Node> nodeList = new ArrayList<Node>(asNlist);
		
		//nodeList.add(A); nodeList.add(B); nodeList.add(C); nodeList.add(D);
		//nodeList.add(E); nodeList.add(F); nodeList.add(G);
		
		Edge A1 = new Edge(A,C,1);
		Edge A2 = new Edge(A,B,2);
		
		Edge B1 = new Edge(B,A,2);
		Edge B2 = new Edge(B,E,3);
		Edge B3 = new Edge(B,C,2);
		Edge B4 = new Edge(B,D,1);
		
		Edge C1 = new Edge(C,A,1);
		Edge C2 = new Edge(C,B,2);
		Edge C3 = new Edge(C,D,4);
		Edge C4 = new Edge(C,E,3);
		Edge C5 = new Edge(C,F,5);
		
		Edge D1 = new Edge(D,B,1);
		Edge D2 = new Edge(D,C,4);
		Edge D3 = new Edge(D,F,6);
		Edge D4 = new Edge(D,G,5);
		
		Edge E1 = new Edge(E,F,1);
		Edge E2 = new Edge(E,C,3);
		Edge E3 = new Edge(E,B,3);
		
		Edge F1 = new Edge(F,E,1);
		Edge F2 = new Edge(F,C,5);
		Edge F3 = new Edge(F,D,6);
		Edge F4 = new Edge(F,G,2);
		
		Edge G1 = new Edge(G,D,5);
		Edge G2 = new Edge(G,F,2);
		
		//pas oublier de changer ca...
		List<Edge> asElist = Arrays.asList(A1,
				A2,
				B1,
				B2,
				B3,
				B4,
				C1,
				C2,
				C3,
				C4,
				C5,
				D1,
				D2,
				D3,
				D4,
				E1,
				E2,
				E3,
				F1,
				F2,
				F3,
				F4,
				G1,
				G2
);
		List<Edge> edgeList = new ArrayList<Edge>(asElist);
		
		graph.setEdges(edgeList);
		graph.setNodes(nodeList);
		// Partie 2: A completer : Implémentation de l’algorithme Dijkstra
		
		Dijkstra d = new Dijkstra(graph);
		
		d.findPath(A,G);
		
		d.afficherTable();

		// Partie 3 : Afficher le chemin le plus court
		System.out.println(d.afficherCourtChemin(A,G));
		System.out.println(d.afficherEdgeList());
	
	}
}
