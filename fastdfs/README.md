# FastDFS Dockerfile network (网络版本)

## 目录介绍
### conf 
Dockerfile 所需要的一些配置文件
当然你也可以对这些文件进行一些修改  比如 storage.conf 里面的 bast_path 等相关

## 使用方法
需要注意的是 你需要在运行容器的时候制定宿主机的ip 用参数 FASTDFS_IPADDR 来指定

```
docker run -d -e FASTDFS_IPADDR=192.168.1.234 -p 8888:8888 -p 32122:32122 -p 32123:32123 -p 8011:80 --name test-fast 镜像id/镜像名称
```
