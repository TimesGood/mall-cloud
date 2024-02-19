# 基础镜像
FROM anapsix/alpine-java:8_server-jre_unlimited
# 维护者author
MAINTAINER lishuyan
# 挂载目录
VOLUME /home
# 指定路径
WORKDIR /home
# jar包名称
ENV JAR_NAME=mall-admin
# 复制jar文件到指定路径
COPY ./target/$JAR_NAME.jar /home/$JAR_NAME.jar
# 参数
ENV PARAMS=$PARAMS
# 时区
ENV TZ Asia/Shanghai
# 暴露端口
EXPOSE 8080
# 启动系统服务
ENTRYPOINT ["/bin/sh","-c","java -Dfile.encoding=utf8 -Djava.security.egd=file:/dev/./urandom -jar  $JAR_NAME.jar ${PARAMS}"]
