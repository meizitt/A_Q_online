module.exports = {
    // 公共路径
    publicPath: "./",
    // 打包路径
    outputDir: "dist",
    // 静态资源路径
    assetsDir: "assets",
    lintOnSave:false,
    productionSourceMap: true, // 不需要生产环境的 source map 设置false（减小dist文件大小，加速构建）
    devServer: {
        open: true,  // npm run serve后自动打开页面
        host: 'localhost',  // 匹配本机IP地址(默认是0.0.0.0)
        port: 8081, // 开发服务器运行端口号
    },
    // 注：目前本项目暂时没有写后台接口，没有跨域问题，暂时不配置proxy
}
