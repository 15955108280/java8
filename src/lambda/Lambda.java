package lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * description
 *
 * @author YXP 2019/08/12 17:08
 */
public class Lambda {
    public static void printValur(String str) {
        System.out.println("print value : " + str);
    }
    static List<Something> chidrenList = new ArrayList<>();

    public static void main(String[] args) {
        Something something1 = new Something();
        something1.setId(1L);
        something1.setParentId(-1L);
        Something something2 = new Something();
        something2.setId(2L);
        something2.setParentId(1L);
        Something something3 = new Something();
        something3.setId(3L);
        something3.setParentId(1L);
        Something something4 = new Something();
        something4.setId(4L);
        something4.setParentId(3L);
        List result = new ArrayList();
        result.add(something1);
        result.add(something2);
        result.add(something3);
        result.add(something4);
        List<Something> list= getChidlren(result,1L);
        list.forEach(something-> System.out.println("节点"+something.getId()));
    }
    public static List getChidlren(List<Something> list ,Long Id) {
        Something something;
        for(int i=0;i<list.size();i++){
            System.out.println("第"+i+"次循环");
            something = list.get(i);
            if (something.getParentId().equals(Id)) {

                list.remove(something);
                chidrenList.add(something);
                getChidlren(list,something.getId());
            }
        }
        return chidrenList;
    }
}
