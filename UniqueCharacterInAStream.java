// "static void main" must be defined in a public class.
class Main {
    public static void main(String[] args) {
      NonRepeatingCharacter nrc = new NonRepeatingCharacter();
      String stream = "attsbastdaek"; 
      for(int i=0;i<stream.length();++i){
        char ch = stream.charAt(i);
        nrc.add(ch);
        if(i%3==0){
          System.out.println("firstUnique:"+nrc.getFirstUnique());
        }
      }
  
    }
  }



class NonRepeatingCharacter{
    
    class Node{
        char val;
        Node prev;
        Node next;
        
        Node(char c){
            this.val = c;
            this.prev=null;
            this.next=null;
        }
    }
    
    
    Node head=null;
    Node tail=null;
    Map<Character,Node> map = new HashMap<>();
    public NonRepeatingCharacter(){
        head = new Node('1');
        tail = new Node('2');
        
        head.next=tail;
        tail.prev = head;
        
        
    }
    
   public char getFirstUnique(){
       if(head.next!=tail){
           return head.next.val;
       }
       else
           return '0';
   }
    
   public void add(char ch){
       //check in map
       if(map.containsKey(ch) && map.get(ch)!=null){
           Node n = map.get(ch);
           n.next.prev=n.prev;
           n.prev.next=n.next;
           map.put(ch,null);
           return;
       }
       
       //insert new
       if(!map.containsKey(ch)){
           map.put(ch,new Node(ch));
           Node tempPre = tail.prev;
           tail.prev.next = map.get(ch);
           map.get(ch).next=tail;
           tail.prev = map.get(ch);
           map.get(ch).prev = tempPre;
       }
 
   }
    
}
