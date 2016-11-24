package sam.member;

import org.springframework.stereotype.Service;
import sam.member.model.Member;
import sam.member.model.MemberXml;

import java.util.HashMap;

import static java.util.Objects.isNull;

/**
 * Created by sam on 2016. 11. 19..
 */
@Service
public class MemberService {

    private HashMap<String, Object> members = new HashMap<String, Object>() {
        {
            put("attdro", new HashMap<String, String>(){
                {
                    put("id", "attdro");
                    put("email", "rosd0000@gmail.com");
                    put("name", "sam");
                }
            });
        }
    };

    public boolean create(Member object) {
        members.put(object.getId(), object);
        return true;
    }

    public MemberXml findOne(String memberId) {
        HashMap<String, String> m = (HashMap<String, String>) members.get(memberId);
        if (isNull(m)) return null;

        return new MemberXml(m.get("id"), m.get("email"), m.get("name"));
    }

    public MemberXml findOneXml(String memberId) {
        HashMap<String, String> m = (HashMap<String, String>) members.get(memberId);
        if (isNull(m)) return null;

        return new MemberXml(m.get("id"), m.get("email"), m.get("name"));
    }


    public boolean update(Member object) {
        HashMap<String, String> m = (HashMap<String, String>) members.get(object.getId());
        m.put("email", object.getEmail());
        m.put("name", object.getName());

        members.put(object.getId(), m);
        return true;
    }

    public boolean delete(String memberId) {
        HashMap<String, String> m = (HashMap<String, String>) members.get(memberId);

        if (isNull(m)) {
            return false;
        }

        members.remove(memberId);
        return true;
    }
}