package com.plyg.airchat.video

/** A frame of video, put back together by airchat-media (protocol §8.6, §9.9). */
class VideoFrame(
    val stream: ByteArray,
    /** Whose: the contact, or a group call's participant (by the app's number for it). */
    val from: Long,
    val key: Boolean,
    /** Quarter turns clockwise that show it upright. */
    val rotation: Int,
    val width: Int,
    val height: Int,
    /** H.264, Annex B. */
    val data: ByteArray,
)
