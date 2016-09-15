app.config(function ($httpProvider) {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
    $httpProvider.defaults.withCredentials = true;
});
app.config(function (blockUIConfigProvider) {
    // 修改默认的提示信息
    blockUIConfigProvider.message("executing...");
    // 修改UI不可见时默认的延迟时间为100ms
    blockUIConfigProvider.delay(1);
    // 禁用自动阻塞页面展示配置项
    blockUIConfigProvider.autoBlock(false);
});