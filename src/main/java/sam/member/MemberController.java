package sam.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sam.util.MultipartFileUpload;

import javax.validation.Valid;

/**
 * Created by sam on 2016. 11. 24..
 */
@RestController
@RequestMapping("members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * POST - member add
     *
     * @param object
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@Valid Member object) {
        return memberService.create(object);
    }

    /**
     * GET - get member
     *  content type : xml
     *
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/{memberId}", method = RequestMethod.GET, headers = "Accept=text/xml")
    public Member findOneXml(@PathVariable("memberId") String memberId) {
        return memberService.findOne(memberId);
    }

    /**
     * GET - get member
     *  content type : json
     *
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/{memberId}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public Member findOneJson(@PathVariable("memberId") String memberId) {
        return memberService.findOne(memberId);
    }

    /**
     * PUT - member update
     *
     * @param object
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public boolean update(Member object) {
        return memberService.update(object);
    }

    /**
     * PUT - member img update
     *
     * @param userId
     * @param userImg
     * @return
     */
    @RequestMapping(value = "/{user_id}/img/upload", method = RequestMethod.POST)
    public boolean updateUserImg(
            @PathVariable("user_id")String userId,
            @RequestParam("user_img_url")MultipartFile userImg){

        if(userImg != null){
            String userImgUrl = MultipartFileUpload.uploadUserPrImg(userImg);
            return memberService.updateUserImg(userId, userImgUrl);
        }

        return false;
    }

    /**
     * DELETE - member delete
     *
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/{memberId}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("memberId") String memberId) {
        return memberService.delete(memberId);
    }
}