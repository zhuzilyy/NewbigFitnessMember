package com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.UpdateVersion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okserver.OkDownload;
import com.member.gufei.bigfitness.Constants;
import com.member.gufei.bigfitness.com.GuFei.Dialog.UpdateDialog;

import java.io.File;

/**
 * Created by Jue on 16/6/13.1122
 * 更新版本
 */
public class AppUpdate {

    private Context mContext;
    private boolean isAutoInstall = false;
    private UpdateDialog updateDialog;
    private UpdateBean updateBean;
    public AppUpdate(Context context,UpdateBean updateBean) {
        mContext = context;
        updateDialog = new UpdateDialog(mContext);
        this.updateBean = updateBean;
    }

    public interface OnResult {
        /**
         * 有新版本
         */
        void onNewVersion();

        /**
         * 已是最新版本
         */
        void onLatestVersion();

        /**
         * 下载进度
         *
         * @param current 已下载大小
         * @param total   总大小
         */
        void onDownloading(long current, long total);

        /**
         * 下载完成
         */
        void onDownLoaCompleted();

        /**
         * 错误
         */
        void onError();
    }


    public void httpCheckUpdate(final OnResult resultListener) {
       /* final Call call = Http.getHttpService().checkUpdate(ModelUtil.getVersion());
        call.enqueue(new Callback<VersionBean>() {
            @Override
            public void onResponse(Call<VersionBean> call, Response<VersionBean> response) {
                final VersionBean bean = response.body();
                if (bean == null)
                    return;
                Logger.e(Instance.gson.toJson(bean));
                if (bean.getCode().equals("0")) {
                    if (resultListener != null)
                        resultListener.onNewVersion();
                    updateDialog.setOnUpdateListener(new UpdateDialog.OnUpdateListener() {
                        @Override
                        public void onUpdate() {
                            downLoadApk(bean.getData().getInfo().getUrl(), resultListener);
                        }
                    });
                    updateDialog.setData("最新版本：" + bean.getData().getInfo().getVersion_name() + "\n" +
                            "版本大小：" + bean.getData().getInfo().getSize() + "\n" +
                            "更新内容\n" + bean.getData().getInfo().getDescription());
                    updateDialog.show();
                } else {
                    if (resultListener != null)
                        resultListener.onLatestVersion();
                }
            }

            @Override
            public void onFailure(Call<VersionBean> call, Throwable t) {
            }
        });*/

      /*  RequestParams params = new RequestParams("https://app.aplusinst.com/version");
        params.addParameter("version_name",10);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (true) {
                    if (resultListener != null)
                        resultListener.onNewVersion();
                        updateDialog.setOnUpdateListener(new UpdateDialog.OnUpdateListener() {
                        @Override
                        public void onUpdate() {
                            downLoadApk("https://raw.githubusercontent.com/WVector/AppUpdateDemo/master/apk/sample-debug.apk", resultListener);
                        }
                    });
                    updateDialog.setData("最新版本：" +28 + "\n" +
                            "版本大小：5M"  + "\n" +
                            "更新内容");
                    updateDialog.show();
                } else {
                    if (resultListener != null)
                        resultListener.onLatestVersion();
                }
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
*/
        if (resultListener != null)
            resultListener.onNewVersion();
            updateDialog.setOnUpdateListener(new UpdateDialog.OnUpdateListener() {
            @Override
            public void onUpdate() {
                downLoadApk(Constants.appDownLoadUrl, resultListener);
            }
        });
        String version = updateBean.getRows().getVersionInfo();
        updateDialog.setData("最新版本.：" +version );
        updateDialog.show();
    }


    //普通安装
    private static void installNormal(Context context, String apkPath) {
        File file = new File(apkPath);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        // 由于没有在Activity环境下启动Activity,设置下面的标签
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 24) { //判读版本是否在7.0以上
            //参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致   参数3  共享的文件
            Uri apkUri =
                    FileProvider.getUriForFile(context, "com.member.gufei.bigfitness.fileprovider", file);
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file),
                    "application/vnd.android.package-archive");
        }
        context.startActivity(intent);


    }


    /**
     * 通过隐式意图调用系统安装程序安装APK
     */
    public static void install(Context context) {
        File file = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                , "myApp.apk");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        // 由于没有在Activity环境下启动Activity,设置下面的标签
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 24) { //判读版本是否在7.0以上
            //参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致   参数3  共享的文件
            Uri apkUri =
                    FileProvider.getUriForFile(context, "com.member.gufei.bigfitness.fileprovider", file);
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file),
                    "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

    //下载新版apk
    private void downLoadApk(String url, final OnResult resultListener) {
        updateDialog.setProgress(0);

        GetRequest<File> request = OkGo.<File>get(url);

        final com.lzy.okserver.download.DownloadTask task2 = OkDownload.request(url, request)//
                .priority(88)//
                .save()//
                .register(new com.lzy.okserver.download.DownloadListener("DownLoadApk") {
                    @Override
                    public void onStart(com.lzy.okgo.model.Progress progress) {

                    }

                    @Override
                    public void onProgress(final com.lzy.okgo.model.Progress progress) {
                        ((Activity) mContext).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (resultListener != null)
                                    resultListener.onDownloading(progress.currentSize, progress.totalSize);
                                if (!isAutoInstall) {
                                    updateDialog.setProgress((int) (progress.currentSize * 100 / progress.totalSize));
                                }
                                if (progress.status == 5) {
                                    if (resultListener != null)
                                        resultListener.onDownLoaCompleted();
                                    if (isAutoInstall) {
                                    } else {
                                        updateDialog.dismiss();
                                        installNormal(mContext, progress.filePath);
                                    }
                                }
                            }
                        });
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Progress progress) {

                    }

                    @Override
                    public void onFinish(File file, com.lzy.okgo.model.Progress progress) {

                    }

                    @Override
                    public void onRemove(com.lzy.okgo.model.Progress progress) {

                    }
                });
        task2.start();


        updateDialog.setOnCancelListener(new UpdateDialog.OnCancelListener() {
            @Override
            public void onCancel() {
                task2.remove();
            }
        });

    }



}
