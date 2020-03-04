package com.zw.patten.struct.t4.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JavaBasic
 * @description: 组合模式杀毒示例
 * @author: zw-cn
 * @create: 2020-03-04 10:02
 */
public class KillVirus {
    public static void main(String[] args) {
        Folder f1 = new Folder("下载");
        AbstractFile t1 = new TxtFile("《码农翻身》");
        AbstractFile i1 = new ImageFile("《蒙娜丽莎》");
        AbstractFile v1 = new VideoFile("《小丑》");
        Folder f2 = new Folder("百度网盘");
        AbstractFile t2 = new TxtFile("《Linux私房菜》");
        AbstractFile i2 = new ImageFile("《5杀截图》");
        AbstractFile v2 = new VideoFile("《飞跃疯人院》");

        f1.add(t1);
        f1.add(i1);
        f1.add(v1);

        f2.add(t2);
        f2.add(i2);
        f2.add(v2);

        f1.add(f2);
        f1.Kill();

    }
}
interface AbstractFile{
    void Kill();
}
class TxtFile implements AbstractFile{
    private String name;

    public TxtFile(String name) {
        this.name = name;
    }

    @Override
    public void Kill() {
        System.out.println("killing txt file->"+name);
    }
}
class ImageFile implements AbstractFile{
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void Kill() {
        System.out.println("killing image file->"+name);
    }
}
class VideoFile implements AbstractFile{
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void Kill() {
        System.out.println("killing video file->"+name);
    }
}

class Folder implements AbstractFile{
    private String name;
    private List<AbstractFile> list = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile f){
        list.add(f);
    }
    public void remove(AbstractFile f){
        list.remove(f);
    }
    public AbstractFile get(int index){
        return list.get(index);
    }
    @Override
    public void Kill() {
        System.out.println("查杀文件夹->"+name);
        for (AbstractFile file : list) {
            file.Kill();
        }
    }
}