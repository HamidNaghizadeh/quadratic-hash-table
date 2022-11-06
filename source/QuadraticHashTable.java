
public class QuadraticHashTable {

  Object[] table;

  private static final int DEFAULT_BASE_NUMBER=5;
  private static final int DEFAULT_A_VALUE=5;
  private static final int DEFAULT_B_VALUE=10;

  private int size;
  private int count;

  private int a;
  private int b;

  public QuadraticHashTable(){
    this(DEFAULT_BASE_NUMBER);
  }

  public QuadraticHashTable(int baseNumber){
    if (baseNumber<=0){
      baseNumber=DEFAULT_BASE_NUMBER;
    }
    size=(int) Math.pow(2,baseNumber);
    table=new Object[size];
    this.a=DEFAULT_A_VALUE;
    this.b=DEFAULT_B_VALUE;

  }

  public QuadraticHashTable(int baseNumber,int a, int b){
    if (baseNumber<=0){
      baseNumber=DEFAULT_BASE_NUMBER;
    }
    size=(int) Math.pow(2,baseNumber);
    table=new Object[size];
    this.a=b;
    this.b=b;

  }



  public void insert(Object objectKey){
    String strKey=String.valueOf(objectKey);
    int key=Integer.parseInt(strKey);
    if(exist(objectKey)!=-1){
      System.out.println(Main.RED_BOLD + "This key is already in Hash Table" + Main.RESET);
      return;
    }

    int index=hash(key);
    if (index==-1){
      System.out.println(Main.RED_BOLD + "Hash Table is Full ! -_- " + Main.RESET);
      return;
    }

    table[index]=objectKey;
    count++;
    System.out.println(Main.GREEN_BOLD + "Key < " + objectKey + " > inserted to Hash Table. The Index that the key saved in that is : " + index + Main.RESET);

  }


  private int hash(int key){
    int generatedNumber=key%size;
    if (table[generatedNumber]!=null){
      generatedNumber=quadraticHash(generatedNumber);
    }
    return generatedNumber;
  }


  private int quadraticHash(int previousGenerated){
    int generatedNumber=-1;
    for (int i=0;i<=size-1;i++) {
      generatedNumber =(int) (previousGenerated + (a*(Math.pow((double) i,2)) + (b * i))) % size;
      if (table[generatedNumber]==null){
        break;
      }
    }
    return generatedNumber;
  }


  private int exist(Object key){
    for (int i=0;i<size;i++){
      if (table[i]!=null){
        if (table[i].equals(key)){
          return i;
        }
      }
    }
    return(-1);
  }


  public boolean erase(Object objectKey){
    int keyIndexInTable=exist(objectKey);
    if (keyIndexInTable!=-1){
      table[keyIndexInTable]=null;
      count--;
      return true;
    }
   return false;
  }


  public void clear(){
    table=null;
    count=0;
  }

  public void print(){
    if(table==null){
      for (int i=0;i<size;i++){
        System.out.print(" null ");

      }
    }
    else{
      for (int i=0;i<size-1;i++) {

        System.out.print(table[i] + " ");

      }

    }
  }

  public int size(){
    return this.count;
  }

  public int capacity(){
    return this.size;
  }

  public double loadFactor(){
    return ((double) count/size);
  }

  public boolean isEmpty(){
    return count==0;
  }

  public boolean exist(Object key){
    return exist(key)!=-1;
  }

  public Object bin(int index){
    return table[index];
  }

}
