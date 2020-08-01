package com.cgfay.cavfoundation.export;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cgfay.cavfoundation.AVAudioMix;
import com.cgfay.cavfoundation.AVAsset;
import com.cgfay.cavfoundation.AVVideoComposition;
import com.cgfay.coremedia.AVTime;
import com.cgfay.coremedia.AVTimeRange;

import static com.cgfay.cavfoundation.export.AVAssetExportPreset.AVExportPresetQualityMedium;

/**
 * 媒体导出器
 */
public class AVAssetExportSession {

    /**
     * 输入媒体资源
     */
    private AVAsset mAsset;

    /**
     * 导出参数(presetName)
     */
    private AVAssetExportPreset mPreset;

    /**
     * 输出Uri
     */
    private Uri mOutputUri;

    /**
     * 导出状态
     */
    private AVAssetExportSessionStatus mStatus;

    /**
     * 导出进度
     */
    private float mProgress;

    /* Specifies a time range to be exported from the source.
    The default timeRange of an export session is kCMTimeZero..kCMTimePositiveInfinity,
    meaning that the full duration of the asset will be exported. */
    /**
     * 导出的时钟区间
     */
    private AVTimeRange mTimeRange;

    /* Provides an estimate of the maximum duration of exported media that is possible given the source asset,
    the export preset, and the current value of fileLengthLimit.
    The export will not stop when it reaches this maximum duration;
    set the timeRange property to export only a certain time range.  */
    /**
     * 最大展示时长
     */
    private AVTime mMaxDuration;

    /* Indicates whether non-default audio mixing is enabled for export and supplies the parameters for audio mixing.  Ignored when export preset is AVAssetExportPresetPassthrough. */
    /**
     * 混音描述对象
     */
    @Nullable
    private AVAudioMix mAudioMix;

    /* Indicates whether video composition is enabled for export and supplies the instructions for video composition.*/
    /**
     * 视频渲染描述对象
     */
    @Nullable
    private AVVideoComposition mVideoComposition;

    /**
     * 导出接口回调
     */
    private OnExportHandler mExportHandler;

    public AVAssetExportSession() {

    }

    /**
     * 使用AVAsset初始化导出器
     * @param asset
     */
    public void initWithAsset(AVAsset asset) {
        initWithAsset(asset, AVExportPresetQualityMedium);
    }

    /**
     * 使用AVAsset初始化导出器
     * @param asset
     * @param preset
     */
    public void initWithAsset(AVAsset asset, AVAssetExportPreset preset) {
        mAsset = asset;
        mPreset = preset;
    }

    /**
     * 异步导出媒体文件
     * @param handler 监听接口
     */
    public void exportAsynchronouslyWithCompletionHandler(OnExportHandler handler) {
        mExportHandler = handler;
    }

    /**
     * 取消导出
     */
    public void cancelExport() {

    }

    /**
     * 释放资源
     */
    public void release() {

    }

    /**
     * 设置导出输出接口
     */
    public void setOutputUri(@NonNull Uri uri) {
        mOutputUri = uri;
    }

    /**
     * 设置时间区间
     * @param range
     */
    public void setTimeRange(AVTimeRange range) {
        mTimeRange = range;
    }

    /**
     * 获取导出状态
     */
    public AVAssetExportSessionStatus getStatus() {
        return mStatus;
    }

    /**
     * 获取导出进度
     */
    public float getProgress() {
        return mProgress;
    }

    /**
     * 导出接口回调
     */
    public interface OnExportHandler {
        void onExport(AVAssetExportSession session, AVAssetExportSessionStatus status);
    }
}
