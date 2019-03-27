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
		Edge B3 = new Edge(B,E,3);
		Edge B2 = new Edge(B,C,2);
		Edge B1 = new Edge(B,D,1);
		Edge C3 = new Edge(C,E,3);
		Edge C5 = new Edge(C,F,5);
		Edge C4 = new Edge(C,D,4);
		Edge D6 = new Edge(D,F,6);
		Edge D5 = new Edge(D,G,5);
		Edge E1 = new Edge(E,F,1);
		Edge F2 = new Edge(F,G,2);
		
		List<Edge> asElist = Arrays.asList(A1,A2,B3,B2,B1,C3,C5,C4,D6,D5,E1,F2);
		List<Edge> edgeList = new ArrayList<Edge>(asElist);
		
		graph.setEdges(edgeList);
		graph.setNodes(nodeList);
		// Partie 2: A completer : Implémentation de l’algorithme Dijkstra
		
		Dijkstra d = new Dijkstra(graph);
		
		d.findPath(/* Spécifiez les paramètres */);
		
		d.afficherTable();

		// Partie 3 : Afficher le chemin le plus court
		System.out.println(d.afficherCourtChemin(/* Spécifiez les paramètres */));
	
	}
}
