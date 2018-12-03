package com.member.gufei.bigfitness.component;

/**
 * 版本更新管理
 *
 * @author GuFei
 * @version 2016 08 03 9:07
 *
 * 暂时关闭
 */
public class UpdateManager {

//    /* 下载中 */
//    private static final int DOWNLOAD = 1;
//    /* 下载结束 */
//    private static final int DOWNLOAD_FINISH = 2;
//    /* 保存解析的XML信息 */
//    String updateVersionName, updateUrl;
//    /* 下载保存路径 */
//    private String savePath;
//    /* 记录进度条数量 */
//    private int progress;
//    /* 是否取消更新 */
//    private boolean cancelUpdate = false;
//
//    private Api api;
//    private Context context;
//    /* 更新进度条 */
//    private ProgressBar mProgress;
//    private TextView tvProgress;
//    private AlertDialog mDownloadDialog;
//    private String versionName;
//    private String versionUrl;
//    private int must;
//
//    public UpdateManager(Context context, Api api) {
//        this.context = context;
//        this.api = api;
//    }
//
//    public void checkUpdate() {
//        final PackageManager packageManager = context.getPackageManager();
//        final PackageInfo packInfo;
//        try {
//            packInfo = packageManager.getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//            return;
//        }
//        api.getNewVersion()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<AppVersionResponse>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onNext(final AppVersionResponse version) {
//                        versionName = version.name;
//                        versionUrl = version.url;
//                        must = version.must;
//                        if (version.code > packInfo.versionCode) {
//                            StringBuilder str = new StringBuilder();
//                            str.append(version.name).append("\n");
//                            String strValue = version.description.replace('|', '\n');
//                            str.append(strValue);
//                            if (must == 1) {
//                                new AlertDialog.Builder(context)
//                                        .setTitle("更新提示:")
//                                        .setMessage(str.toString())
//                                        .setCancelable(false)
//                                        .setPositiveButton("现在更新", new DialogInterface.OnClickListener() {
//                                            @Override
//                                            public void onClick(DialogInterface dialogInterface, int i) {
//                                                updateVersionName = versionName;
//                                                updateUrl = versionUrl;
//                                                showDownloadDialog();
//                                            }
//                                        }).show();
//                            } else {
//                                new AlertDialog.Builder(context)
//                                        .setTitle("更新提示:")
//                                        .setMessage(str.toString())
//                                        .setCancelable(false)
//                                        .setPositiveButton("现在更新", new DialogInterface.OnClickListener() {
//                                            @Override
//                                            public void onClick(DialogInterface dialogInterface, int i) {
//                                                updateVersionName = versionName;
//                                                updateUrl = versionUrl;
//                                                showDownloadDialog();
//                                            }
//                                        }).setNegativeButton("暂不更新", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialogInterface, int i) {
//                                        dialogInterface.dismiss();
//                                    }
//                                }).show();
//                            }
//                        }
//                    }
//                });
//
//    }
//
//    /**
//     * 显示软件下载对话框
//     */
//    private void showDownloadDialog() {
//        final LayoutInflater inflater = LayoutInflater.from(context);
//        View v = inflater.inflate(R.layout.update_progress, null);
//        mProgress = (ProgressBar) v.findViewById(R.id.update_progress);
//        tvProgress = (TextView) v.findViewById(R.id.update_progress_text);
//        // 构造软件下载对话框
//        if (must == 1) {
//            mDownloadDialog = new AlertDialog.Builder(context)
//                    .setTitle("正在更新，请稍候...")
//                    .setView(v)
//                    .setCancelable(false)
//                    .show();
//        } else {
//            mDownloadDialog = new AlertDialog.Builder(context)
//                    .setTitle("正在更新，请稍候...")
//                    .setView(v)
//                    .setCancelable(false)
//                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            dialogInterface.dismiss();
//                            cancelUpdate = true;
//                        }
//                    }).show();
//        }
//        downloadApk();
//    }
//
//    /**
//     * 下载apk文件
//     */
//    private void downloadApk() {
//        // 启动新线程下载软件
//        new downloadApkThread().start();
//    }
//
//    /**
//     * 下载文件线程
//     *
//     * @author coolszy
//     * @date 2012-4-26
//     * @blog http://blog.92coding.com
//     */
//    private class downloadApkThread extends Thread {
//        @Override
//        public void run() {
//            try {
//                // 判断SD卡是否存在，并且是否具有读写权限
//                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//                    // 获得存储卡的路径
//                    String sdpath = Environment.getExternalStorageDirectory() + "/";
//                    savePath = sdpath + "download";
//                    URL url = new URL(updateUrl);
//                    // 创建连接
//                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                    conn.connect();
//                    // 获取文件大小
//                    int length = conn.getContentLength();
//                    // 创建输入流
//                    InputStream is = conn.getInputStream();
//
//                    File file = new File(savePath);
//                    // 判断文件目录是否存在
//                    if (!file.exists()) {
//                        file.mkdir();
//                    }
//                    File apkFile = new File(savePath, updateVersionName + ".apk");
//                    FileOutputStream fos = new FileOutputStream(apkFile);
//                    int count = 0;
//                    // 缓存
//                    byte buf[] = new byte[1024];
//                    // 写入到文件中
//                    do {
//                        int numread = is.read(buf);
//                        count += numread;
//                        // 计算进度条位置
//                        progress = (int) (((float) count / length) * 100);
//                        // 更新进度
//                        if (numread <= 0) {
//                            // 下载完成
//                            installApk();
//                            break;
//                        } else {
//
//                            mProgress.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    mProgress.setProgress(progress);
//                                }
//                            });
//                            tvProgress.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    tvProgress.setText(String.format("%d%%", progress));
//                                }
//                            });
//                        }
//                        // 写入文件
//                        fos.write(buf, 0, numread);
//                    } while (!cancelUpdate);// 点击取消就停止下载.
//                    fos.close();
//                    is.close();
//                }
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            // 取消下载对话框显示
//            mDownloadDialog.dismiss();
//        }
//    }
//
//    /**
//     * 安装APK文件
//     */
//    private void installApk() {
//        File apkfile = new File(savePath, updateVersionName + ".apk");
//        if (!apkfile.exists()) {
//            return;
//        }
//        // 通过Intent安装APK文件
//        Intent i = new Intent(Intent.ACTION_VIEW);
//
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        i.setDataAndType(Uri.parse("file://" + apkfile.toString()), "application/vnd.android.package-archive");
//        context.startActivity(i);
//        MainActivity.mainActivity.finish();
//    }
}