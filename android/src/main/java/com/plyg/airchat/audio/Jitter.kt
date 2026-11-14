package com.plyg.airchat.audio

/**
 * One sender's jitter buffer: airchat-media's (`jitter.rs`), reached through the app's FFI. It puts
 * packets back in order and paces them for playout, one per 20 ms frame.
 */
interface Jitter {
    /** A packet as it came, with its sequence number; any thread. */
    fun push(seq: UInt, packet: ByteArray)

    /** The packet to play now, or null for a lost or late one, or silence; on the playback thread. */
    fun next(): ByteArray?
}
