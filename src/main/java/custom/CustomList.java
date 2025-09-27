package custom;

public class CustomList<E> {
    private static final int default_size = 10;     // List의 최초 기본 사이즈
    private E[] list;                               // 최초 배열
    private int size;                               // 현재 저장된 데이터 개수

    // 생성자 -> List를 생성할 때
    public CustomList(){
        this.list = (E[]) new Object[default_size]; // 기본 사이즈로 배열을 생성하고
        // new E[]로 직접 생성이 불가하여 Object로 배열 생성 후, 형변환을 진행해야한다.
        this.size = 0;                              // 최초니깐 저장된 데이터 개수 0개
    } // func end

    /**
     * 현재 List의 데이터 개수를 반환하는 메소드
     * @author Jeonghoon
     * @return int
     */
    public int size(){
        return this.size;
    } // func end

    /**
     * 배열을 출력하면 주소값이 반환되므로, 배열을 확인하기 위한 String 변환 메소드
     * @author Jeonghoon
     * @return String
     */
    public String toString(){
        StringBuilder toString = new StringBuilder();
        toString.append("[");                       // 대괄호 열기
        for (int i = 0; i< size; i++){              // list를 순회하면서
            toString.append(list[i]);               // 각각의 데이터를 추가
            if (i < size - 1){                      // 마지막 데이터가 아니면
                toString.append(", ");              // 가독성을 위한 ', ' 추가
            } // if end
        } // for end
        toString.append("]");                       // 대괄호 닫기
        return toString.toString();                 // 최종적으로 toString 반환
    } // func end

    /**
     * [추가될 데이터]를 매개변수로 받아서 리스트에 데이터를 추가하고
     * 저장된 데이터 개수를 1 증가시킨다.
     * @author Jeonghoon
     * @param data 추가될 데이터
     */
    public void add(E data){
        if (size == list.length){                   // 현재 저장된 개수와 배열의 크기가 같아지면
            list = plusSize();                      // 배열의 크기를 증가시켜, 기존 배열에 저장한다.
        } // if end
        list[size] = data;                          // 입력받은 데이터를 list에 추가한다.
        size++;                                     // size를 1 증가시킨다.
    } // func end

    /**
     * 최초 기본 사이즈보다 많은 데이터가 입력되었을 때
     * 더 큰 배열을 만들고, 기존 배열을 추가한다.
     * @author Jeonghoon
     */
    private E[] plusSize(){
        int new_size = list.length + 10;            // 기존 배열 크기 + 10
        E[] new_list = (E[]) new Object[new_size];  // 새로운 배열 선언
        for (int i = 0; i< size; i++){              // System.arraycopy로 대체 가능
            new_list[i] = list[i];                  // 기존 배열을 새로운 배열에 추가한다.
        } // for end
        return new_list;                            // 새롭게 생성된 배열을 반환한다.
    } // func end

    /**
     * [얻을 인덱스]를 받아서 해당하는 데이터를 반환한다.
     * @author Jeonghoon
     * @param index
     * @return E 해당 리스트의 타입
     */
    public E get(int index){
        // 입력받은 인덱스의 범위 유효성 검사 : throw로 예외 실행
        if (index < 0 || index >= size){            // 0보다 작거나 데이터 개수보다 크면
            // 왜 size 이상임? index는 0부터 시작이기에 데이터가 10개여도 index는 9개까지 존재하므로
            // size가 10이고 index가 10이면, 배열 범위를 벗어나게 됨
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size + ", Index가 범위를 벗어났습니다.");
        } // if end
        return list[index];                         // 해당하는 리스트의 인덱스 값을 반환한다.
    } // func end
} // class end