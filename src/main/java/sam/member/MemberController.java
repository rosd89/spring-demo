package sam.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sam.member.model.Member;
import sam.member.model.MemberXml;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * Created by sam on 2016. 11. 24..
 */
@RestController
@RequestMapping("members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public boolean create(@Valid Member object) {
        return memberService.create(object);
    }

    /**
     * GET - content type - xml
     *
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/{memberId}", method = RequestMethod.GET, headers = "Accept=text/xml")
    public MemberXml findOneXml(@PathVariable("memberId") String memberId) {
        return memberService.findOneXml(memberId);
    }

    /**
     * GET - content type - json
     *
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/{memberId}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public MemberXml findOneJson(@PathVariable("memberId") String memberId) {

        MemberXml member = memberService.findOne(memberId);

        return member;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public boolean update(Member object) {
        return memberService.update(object);
    }

    @RequestMapping(value = "/{memberId}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("memberId") String memberId) {
        return memberService.delete(memberId);
    }
}