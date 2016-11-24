package sam.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sam on 2016. 11. 25..
 */
public class MultipartFileUpload {

    public static String DEFAULT_USER_IMG = "";

    public static String uploadUserPrImg(MultipartFile file){
        String path = new MultipartFileUpload().getRequestSaveDir();

        //String getOriginalFilename()	 업로드 한 파일의 실제!! 이름을 구한다.
        String fileName = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date(System.currentTimeMillis()))
                +"."
                + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);

        FileOutputStream fos = null;

        try{

            byte fileData[] = file.getBytes();
            fos = new FileOutputStream(path + fileName);

            fos.write(fileData);

        }catch(Exception e){

            e.printStackTrace();
            return null;

        }finally{

            if(fos != null){

                try{
                    fos.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        }

        return "/img" + fileName;
    }

    /**
     * multipart는 첨부파일을 업로드 하므로 저장 디렉토리 지정이 필요함
     *
     * @return
     */
    private String getRequestSaveDir() {

        String osName = System.getProperty("os.name");

        if (osName.equals("Windows 7"))
            return "d:/user";
        else if(osName.startsWith("Mac")){
            return "/Users/sam/work/img";
        }
        else
            return "/root/tomcat/tomcat7/webapps/img";
    }

}
