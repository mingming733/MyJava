/**
 * Created by mming on 1/26/17.
 */

import java.util.*;
class Mst {
    public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
        ArrayList<Connection> result = new ArrayList<>();
        Map<String, String> roots = new HashMap<>();
        Set<String> set = new HashSet<>();
        Collections.sort(connections, new Comparator<Connection>() { // sort the connections according to the cost ascendingly.
            @Override
            public int compare(Connection c1, Connection c2) {
                return c1.cost - c2.cost;
            }
        });
        for (Connection connection : connections) {
            roots.put(connection.node1, connection.node1);
            roots.put(connection.node2, connection.node2);
            set.add(connection.node1);
            set.add(connection.node2);
        }
        for (Connection connection : connections) {
            if (notInSameUnion(connection.node1, connection.node2, roots)) { // only add connection that nodes are not in the same uinon, if two node in the same union, we can't add the connection to the result, because a loop will be formed
                result.add(connection);
            }
        }
        if (set.size() - 1 > result.size()) { // if the number of node minus 1 is larger than the number of connected nodes, that mean all the nodes are not connected, so return empty result
            return new ArrayList<Connection>();
        }
        Collections.sort(result, new Comparator<Connection>() {
            @Override
            public int compare(Connection c1, Connection c2) {
                if (c1.node1.equals(c2.node1)) {
                    return c1.node2.compareTo(c2.node2);
                }
                return c1.node1.compareTo(c2.node1);
            }
        });
        return result;
    }

    private static boolean notInSameUnion(String node1, String node2, Map<String, String> roots) { //check if the two node in the same union
        String root1 = find(node1, roots);
        String root2 = find(node2, roots);
        if (root1.equals(root2)) {    // if two node in the same union, return false
            return false;
        }
        roots.put(root1, root2); // put root1 as root2's parent, thus they will have the same root,so in the same union.
        return true;
    }

    private static String find(String city, Map<String, String> roots) { // find out the root of a city, AKA, which union the city is in.
        if (city.equals(roots.get(city))) {
            return city;
        }
        return find(roots.get(city), roots); // find recursively to the root of the city
    }
}

