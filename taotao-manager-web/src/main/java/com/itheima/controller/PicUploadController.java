package com.itheima.controller;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.itheima.bean.PicUploadResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/*
 *  @创建时间:  2020/12/16 8:44
 *  @描述：    上传图片
 */
@RestController
public class PicUploadController {

    @Autowired
    private FastFileStorageClient storageClient;

    //读取application.properties里面的iamge_server属性的值，注入进来
    @Value("${image_server}")
    private String IMAGE_SERVER_URL;

    private static String[] TYPE = { ".jpg", ".jpeg", ".png", ".bmp", ".gif" };

    // filePostName : "uploadFile", //上传文件名
    // uploadJson : '/rest/pic/upload', //图片上传请求路径
    // dir : "image" //上传文件类型

    /**
     * 图片上传
     *
     * @param uploadFile
     * @return
     * @throws Exception
     */
    @RequestMapping("/rest/pic/upload")
    public PicUploadResult upload(MultipartFile uploadFile) throws Exception {
        // 声明标志位
        boolean flag = false;

        // 初始化返回数据,初始化上传失败
        PicUploadResult picUploadResult = new PicUploadResult();
        picUploadResult.setError(1);

        // 校验后缀
        for (String type : TYPE) {
            String oname = uploadFile.getOriginalFilename();
            // 如果后缀是要求的格式结尾，标志位设置为true，跳出寻汗
            if (StringUtils.endsWithIgnoreCase(oname, type)) {
                flag = true;
                break;
            }
        }

        // 如果校验失败，直接返回
        if (!flag) {
            return picUploadResult;
        }

        // 重置标志位
        flag = false;

        // 图片内容校验
        try {
            BufferedImage image = ImageIO.read(uploadFile.getInputStream());
            if (image != null) {
                picUploadResult.setHeight(String.valueOf(image.getHeight()));
                picUploadResult.setWidth(String.valueOf(image.getWidth()));
                flag = true;
            }
        } catch (Exception e) {
        }

        // 校验成功，需要上传图片
        if (flag) {

            // 1. 加载tracker配置文件
            //ClientGlobal.init(System.getProperty("user.dir") + "/src/main/resources/tracker.conf");

            // 2. 创建TrackerClient
            //TrackerClient trackerClient = new TrackerClient();

            // 3. 获取TrackerServer
            //TrackerServer trackerServer = trackerClient.getConnection();

            // 4. 声明StorageServer，为null
            //StorageServer storageServer = null;

            // 5. 创建StorageClient
            //StorageClient storageClient = new StorageClient(trackerServer, storageServer);

            // abcabbaddd 1.2.3.4.jpg
            // 6. 使用StorageClient上传图片
            // 获取上传文件的后缀名
            String ext = StringUtils.substringAfterLast(uploadFile.getOriginalFilename(), ".");

            //开始上传
            //String[] str = storageClient.upload_file(uploadFile.getBytes(), ext, null);
            //参数一：上传文件的输入流对象
            //参数二：上传的文件大小
            //参数三：上传的文件后缀
            //参数四：文件的一些元数据，比如：文件的创建时间，最后修改时间，是谁创建的呀~~~  直接给null即可
            StorePath storePath = storageClient.uploadFile(uploadFile.getInputStream(), uploadFile.getSize(), ext, null);

            //http://192.168.37.161/group1/M00/00/00/wKgloV_Y2TCAH7aOAABp2a94NDM533.jpg

            // storePath.getFullPath(); //group1/M00/00/00/wKgloV_Y2TCAH7aOAABp2a94NDM533.jpg
            //storePath.getGroup(); // group1
            //storePath.getPath(); //M00/00/00/wKgloV_Y2TCAH7aOAABp2a94NDM533.jpg

            // 7. 进行返回的结果的拼接，上传图片的url
           // String picUrl = this.IMAGE_SERVER_URL + "/" + str[0] + "/" + str[1];
            String picUrl = IMAGE_SERVER_URL+ storePath.getFullPath();

            // 设置图片url
            picUploadResult.setUrl(picUrl);

            // 上传成功设置为0
            picUploadResult.setError(0);
        }

        return picUploadResult;
    }

}
