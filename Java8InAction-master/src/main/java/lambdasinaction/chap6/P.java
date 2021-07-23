package lambdasinaction.chap6;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangZhenhua
 * @date 2021/1/15 16:21
 */
public class P {

    String name;
    Long id;
    List<P> ps = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<P> getPs() {
        return ps;
    }

    public void setPs(List<P> ps) {
        this.ps = ps;
    }

    public P(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "P{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", ps=" + ps +
                '}';
    }

    public static void main(String[] args) {
        P aaa = new P("aaa", 1L);
        P aa = new P("aa", 2L);
        P a = new P("a", 3L);
        List<P> aaL = new ArrayList<>();
        aaL.add(aaa);
        aa.setPs(aaL);
        List<P> aL = new ArrayList<>();
        aL.add(aa);
        a.setPs(aL);
        Gson gson = new Gson();
        String s = gson.toJson(a);
        System.out.println(s);
        P p = gson.fromJson("{\n" +
                "    \"name\": \"1\",\n" +
                "    \"id\": 3,\n" +
                "    \"ps\": [\n" +
                "        {\n" +
                "            \"name\": \"1-1\",\n" +
                "            \"id\": 2,\n" +
                "            \"ps\": [\n" +
                "                {\n" +
                "                    \"name\": \"1-1-1\",\n" +
                "                    \"id\": 1,\n" +
                "                    \"ps\": []\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"1-1-2\",\n" +
                "                    \"id\": 1,\n" +
                "                    \"ps\": []\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"1-1-3\",\n" +
                "                    \"id\": 1,\n" +
                "                    \"ps\": [\n" +
                "                        {\n" +
                "                            \"name\": \"1-1-3-1\",\n" +
                "                            \"id\": 1,\n" +
                "                            \"ps\": [\n" +
                "                                {\n" +
                "                                    \"name\": \"1-1-3-1-1\",\n" +
                "                                    \"id\": 1,\n" +
                "                                    \"ps\": []\n" +
                "                                }\n" +
                "                            ]\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"1-2\",\n" +
                "            \"id\": 2,\n" +
                "            \"ps\": [\n" +
                "                {\n" +
                "                    \"name\": \"1-2-1\",\n" +
                "                    \"id\": 1,\n" +
                "                    \"ps\": []\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}", P.class);
        System.out.println(gson.toJson(p));
    }
}
