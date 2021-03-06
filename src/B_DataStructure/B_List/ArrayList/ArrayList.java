package B_DataStructure.B_List.ArrayList;

public class ArrayList {

    private int size = 0;
    private Object[] elementData = new Object[100];


    /**
     * 1. '추가' 메소드
     * */
    public boolean add(Object element){
        elementData[size] = element;
        size++;
        return true;
    }

    public boolean add(int index, Object element){
        // 엘리먼트 중간에 데이터를 추가하기 위해서는
        // 끝의 엘리먼트부터 index의 노드까지 뒤로 한 칸씩 이동시켜야 한다.
        for(int i=size-1; i>=index; i--){
            elementData[i+1] = elementData[i];
        }

        // index에 노드를 추가한다.
        elementData[index] = element;

        // 엘리먼트의 숫자를 1 증가시킨다.
        size++;
        return true;
   }

   public boolean addFirst(Object element){
        return add(0, element);
   }


    /**
     * 2. '삭제' 메소드
     * */
    public Object remove(int index){
        // 엘리먼트를 삭제하기 전에 삭제할 데이터를 removed 변수에 저장한다.
        Object removed = elementData[index];

        // 삭제된 엘리먼트 다음 엘리먼트부터 마지막 엘리먼트까지 순차적으로 이동해서 빈자리를 채운다.
        for(int i=index+1; i<=size-1; i++){
            elementData[i-1] = elementData[i];
        }

        // 크기를 줄인다
        size--;

        // 마지막 위치의 엘리먼트를 명시적으로 삭제해준다.
        elementData[size] = null;
        return removed;
    }

    public Object removeFirst(){
        return remove(0);
    }

    public Object removeLast(){
        return remove(size-1);
    }


    /**
     * 3. '조회' 메소드
     * */
    public Object get(int index){
        return elementData[index];
    }

    public int size(){
        return size;
    }

    public Object indexOf(Object o){
        for(int i=0; i<size; i++){
            if(o.equals(elementData[i])){
                return i;
            }
        }
        return -1;
    }


    /**
     * 4. '출력' 메소드
     * */
    public String toString(){
        String str = "[";
        for(int i=0; i<size; i++){
            str += elementData[i];
            if(i < size-1){
                str += ",";
            }
        }
        return str + "]";
    }
}
