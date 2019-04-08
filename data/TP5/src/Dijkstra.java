import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Map<Edge, Node> dijkstraTableInverse[];
	private Stack<Edge> path;
	private Vector<Edge> edgeList;
	

	public Dijkstra (Graph g) {
		this.graph = g;
	}

	public void findPath (Node s, Node d) {

		dijkstraTable = new HashMap[graph.getNodes().size()];
		dijkstraTableInverse = new HashMap[graph.getNodes().size()];
		path = new Stack<Edge>();
		edgeList = new Vector<Edge>();
		
		//4C dans le tableau a la place de 4D a la palce E5.
		
		// A compléter
		
		final int INFINITY = 99999;
		
		for(int i=0;i < graph.getNodes().size();++i) {
			graph.getNodes().get(i).distance = INFINITY;
		}

		s.distance = 0;
		s.found = true;
		
		//la liste avec les edges de la source
		ArrayList<Edge> list = new ArrayList<Edge>(graph.getEdgesGoingFrom(s));
				
		//l'update autour du noeud source
		for(int i=0;i<list.size();++i) {
			
			int tmpIndex = graph.getNodes().indexOf(list.get(i).getDestination());
			// On update la distance des noeuds qui sont la destination du noeud source
			// modifie le node et non le edge
			graph.getNodes().get(tmpIndex).distance = list.get(i).getDistance() + s.distance;
		}
		
		
		//int currentLength = 0;
		int iteration = 0;
		Edge edgeA_A = new Edge(s,s,0);
		//dijkstraTable[iteration].put(s, edgeA_A);
		//dijkstraTableInverse[iteration].put(edgeA_A, s);
		edgeList.add(edgeA_A);
		path.add(edgeA_A);
		
		iteration++;
		
		while(d.found == false) {
			
			int min = INFINITY;
			
			// Trouver le prochain noeud
			Node bestNode = new Node();
			int bestNodeIndex = 0;
			{	int i = 0;
				//on parcours tous les nodes
				for(Node node : graph.getNodes()) {
					//si le node n'est pas dans l'ensemble et si sa valeur est plus petite
					if( (node.found == false) && (node.distance < min) ) {
						min = node.distance;
						bestNode = node; // El bestos nodos
						bestNodeIndex = i;
					}
					i++;
				}
			}			

			
			//le node trouv� fait partie de l'ensemble.
			graph.getNodes().get(bestNodeIndex).found = true;
			
			Edge bestEdge = new Edge();
			int minEdgeValue = INFINITY;

			//il faut trouver le edge min et l'ajout� au path
			for(int i = 0; i<graph.getEdges().size(); i++) {
				if( (graph.getEdges().get(i).getDestination() == bestNode) && 			//est-ce que la destination est bonne 
/*on triche ici un peu*/(graph.getEdges().get(i).getDistance() < minEdgeValue) &&		//on cherche le meilleur edge
						(graph.getEdges().get(i).getSource().found == true) 			//on verifie si la source est trouvee
						) {
					minEdgeValue = graph.getEdges().get(i).getDistance();
					bestEdge = graph.getEdges().get(i);
				}
			}
			
			//put DestinationNode, edge
			edgeList.add(bestEdge);
			//dijkstraTable[iteration].put(bestNode, bestEdge);
			//dijkstraTableInverse[iteration].put(bestEdge, bestNode);
			
			//dijkstraTable[iteration2-1].get(bestNode).getDestination() != bestEdge.getSource()
			//ajout du edge au path
			int iteration2 = iteration;

				while( edgeList.get(iteration2).getDestination() != bestEdge.getSource() ) {
					path.pop();
					iteration2--;
					if(iteration2 < 0 || path.size() <= 1 )
						break;
				}
				
			
			//on a besoin de faire un seul add toujours...
			
				path.add(bestEdge);

			
			
			/*//on choisi le meilleur edge
			//Pas sur s'il faut parcourir la liste
			for(Edge edge : list) {
				//A-> 		B 					bestNode
				if(edge.getDestination() == graph.getNodes().get(bestNodeIndex)) {// Trouver le edge en fction du node
					currentLength += edge.getDistance();
					break;
				}
			}*/
			
			//la liste avec les edges du bestNode
			list = new ArrayList<Edge>(graph.getEdgesGoingFrom(bestNode));
			
			//l'update
			for(int i=0;i<list.size();++i) {
				//List<Node> tmpNodeList = graph.getNodes();
				//retourne l'index du noeud de destination
				int tmpIndex = graph.getNodes().indexOf(list.get(i).getDestination());
				// On update la distance des noeuds qui sont la destination du noeud source
				// modifie le node et non le edge
				
				//il faut v�rifier si la nouvelle somme est plus petite et si oui on update.
				int distanceEdge = list.get(i).getDistance();
				int distanceNoeud = bestNode.distance;
				if( (distanceEdge + distanceNoeud) < graph.getNodes().get(tmpIndex).distance)
					graph.getNodes().get(tmpIndex).distance = list.get(i).getDistance() + bestNode.distance;
			}
			
			iteration++;
		}
		
		
	}

	private Node getMinimum(Map<Node, Edge> map) {
		Edge min = null;
		for (Node Key : map.keySet()) {
			if ( min == null || map.get(Key).getDistance() < min.getDistance()) {
				min = map.get(Key); 
			}
		}
		return min.getDestination();
	}

	private Edge getMinimum (Edge e1, Edge e2) {
		// A completer
		//pas finit... faire attention aux objets nulls...
		if( e1.getDistance() < e2.getDistance() ) {
			return e1;
		}
		else {
			return e2;
		}
	}
	
	public String afficherCourtChemin (Node source, Node destination) {
		// A completer
		String chemin = "";

		for(int i=0;i<path.size();i++) {
			chemin += path.get(i).getSource().getName() + "->" + 
					path.get(i).getDestination().getName()+ ", ";
		}
		
		return chemin;
	}
	
	public String afficherEdgeList() {
		String chemin = "";

		for(int i=0;i<edgeList.size();i++) {
			chemin += edgeList.get(i).getSource().getName() + "->" + 
					edgeList.get(i).getDestination().getName()+ ", ";
		}
		
		return chemin;
	}

	public void afficherTable () {
		// A completer
		
	}
}
