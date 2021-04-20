package B_DataStructure.A_Array;

public class Array {

    private Object[] data;
    private int count;


    public Array(int maxSize){
        if(maxSize < 0){
            throw new IllegalArgumentException("Illegal Capacity:"+maxSize);
        }

        // 객체 생성 시 받은 maxSize 크기의 배열을 만든다.
        this.data = new Object[maxSize];
        this.count = 0;
    }


    // 배열의 마지막에 obj를 삽입한다.
    public void add(Object obj){
        if(count >= data.length){
            throw new ArrayIndexOutOfBoundsException(count+">="+data.length);
        }

        data[count++] = obj;
    }


    // index의 위치에 obj를 삽입한다. index 뒤의 데이터는 한 칸씩 밀려난다.
    public void add(int index, Object obj){
        if(count >= data.length){
            throw new ArrayIndexOutOfBoundsException(count+">="+data.length);
        }

        for(int i=index; i<count; i++){
            data[i+1] = data[i];
        }
        count++;

        data[index] = obj;
    }


    // index 위치의 데이터를 삭제한다. index 뒤의 데이터는 한 칸씩 당겨진다.
    public void remove(int index){
        if(index >= count){
            throw new ArrayIndexOutOfBoundsException(index+">="+count);
        } else if(index < 0){
            throw new ArrayIndexOutOfBoundsException(index);
        }

        for(int i=index; i<count-1; i++){
            data[i] = data[i+1];
        }
        count--;

        data[count] = null;
    }


    // obj를 찾아서 제거한다.
    public void remove(Object obj){
        int index = find(obj);

        remove(index);
    }


    // index의 데이터를 가져온다.
    public Object get(int index){
        if(index >= count){
            throw new ArrayIndexOutOfBoundsException(index+">="+count);
        }
        return data[index];
    }


    // 배열에서 obj를 찾아서 위치 index를 반환한다.
    public int find(Object obj){
        int index;

        for(index=0; index<count; index++){
            if(data[index].equals(obj)){
                break;
            } else if(index == count-1){
                index = -1;
                break;
            }
        }

        return index;
    }


    // 배열의 데이터를 출력한다.
    public String toString(){
        StringBuffer str = new StringBuffer("[");

        if(count > 0){
            str.append(data[0]);
        }

        for(int i=1; i<count; i++){
            str.append(", ").append(data[i]);
        }

        str.append("]");

        return str.toString();
    }




    // test
    public static void main(String[] args) {

        // 크기 5 의 배열 객체를 생성한다.
        Array arr = new Array(5);

        // 배열에 데이터를 입력한다.
        for(int i=1; i<=5; i++){
            arr.add("데이터-"+i);
        }

        // 현재 배열의 입력된 데이터 전체를 출력한다. toString()
        System.out.println(arr);

        // 배열의 0번째 3번째 데이터를 가져와서 출력한다.
        System.out.println(arr.get(0));
        System.out.println(arr.get(3));

        // index ==3 의 데이터를 제거한다.
        arr.remove(3);

        // 배열의 데이터를 출력한다.
        System.out.println(arr);


        // index == 3 의 위치에 "데이터-4"를 삽입한다.
        arr.add(3, "데이터-4");

        // 배열 전체를 출력한다.
        System.out.println(arr);
    }
}
