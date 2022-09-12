//package BinaryTree;
//
//public class Coinswitch_R1 {
//
//    class GetConnections {
//
//
//        public void getFirstDegreeConnections(TreeNode root, TreeNode node) {
//
//            Queue<TreeNode> q = new LinkedList<>();
//
//            q.add(root);
//
//            Map<TreeNode, List<TreeNode>> levelMap = new HashMap<>();
//
//
//
//            TreeNode prev = null;
//
//            while(!q.isEmpty()) {
//
//                TreeNode curr = q.poll();
//
//                List<TreeNode> level = new ArrayList<>();
//
//                if(curr.left != null) {
//
//                    q.add(curr.left);
//
//                    level.add(curr.left);
//
//                }
//
//                if(curr.right != null) {
//
//                    q.add(curr.right);
//
//                    level.add(curr.left);
//
//                }
//
//                //Track prev for sub-tree nodes
//
//                if(prev != null) {
//
//                    level.add(prev);
//
//                }
//
//
//                if(levelMap.containsKey(curr)) {
//
//                    levelMap.get(curr).addAll(level);
//
//                } else {
//
//                    levelMap.put(curr, level);
//
//                }
//
//            }
//
//        }
//
//    }
//
//
//}
