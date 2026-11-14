# airchat-media

Calls, push-to-talk and video shared by [AirChat](https://github.com/kasimtmc/AirChat) and
[AirChat+](https://github.com/kasimtmc/airchat-plus).

- **Rust crate** (`src/`): the call logic over link records of the
  [AirChat protocol](https://github.com/kasimtmc/airchat-protocol).
  - 1:1 voice and video calls (§8.5, §8.6), push-to-talk, and group voice and video (§9.6, §9.9).
  - Group calls are repeated by the participants.
  - Video frames are cut into parts and put back together, and key frames are asked for when one went missing.
  - The jitter buffer (`jitter`) paces incoming audio for playout.
  - Nothing here encrypts: records travel in the app's link sessions, which do.
  - Nothing touches storage, so calls ring while an app is locked.
- **Android library** (`android/`):
  - microphone and speaker with Opus (`VoiceEngine`, `OggOpus` for voice messages);
  - camera with H.264 (`CameraSender`), and decoding (`VideoReceiver`, `VideoTextureView`), all on the platform's MediaCodec.

## Using it

- **Rust:** take the crate as a path dependency into the submodule, or as a git dependency on the same tag. Make sure its `airchat-protocol` is the app's own, through a `[patch]` if needed, so there is one protocol crate.
- **Events:** the app maps [`Event`] to its own actions and gives [`Media`] the link records it receives. Peers are the app's `i64` numbers (`ContactId`).
- **Android:** add this repository as a git submodule pinned to a tag, then include `android/` as a Gradle project (`include(":media")`, `project(":media").projectDir = file("…/android")`). The Android Gradle plugin comes from the app's build.
  - `VoiceEngine` takes a factory for [`Jitter`](android/src/main/java/com/plyg/airchat/audio/Jitter.kt): the app wraps this crate's jitter buffer as its FFI exposes it.

## Licence

GPL-3.0-or-later.
