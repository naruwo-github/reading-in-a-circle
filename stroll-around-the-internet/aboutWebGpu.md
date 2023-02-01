# WebGPU

## From W3C's docs intro
GPUはレンダリングや計算処理をリッチにするために必要不可欠である。

WebGPUは、GPUハードウェアの機能をWeb上からアクセスできるように公開するAPIで、ネイティブのGPU操作APIを効率よく呼び出せるようゼロから設計されている。

WebGPUはWebGLとは無関係であり、OpenGL ESを明示的に対象外としている。

## From Google Developers docs
WebGPUは、GPU上でレンダリングと計算処理を行うための最新のCG機能で、具体的にはDirect3D 12、Metal、Vulkanを公開する新しいWeb APIである。

下記はそれぞれGPU（ハード）にアクセスするためのAPI。
- Direct3D
    - Microsoftの資料: https://ja.wikipedia.org/wiki/Direct3D
- Metal
    - Appleの資料: https://developer.apple.com/documentation/metal/
- Vulkan
    - Vulkan公式: https://www.vulkan.org/

WebGPUはWebGLのAPIと似ていますが、WebGPUはGPUのより高度な機能へのアクセスを可能にします。WebGLは主に画像を描くためのものですが、他の種類の計算にもなんとか再利用できるのに対し、WebGPUはGPUで一般的な計算を実行するためのFirst-Classサポートを提供する。

## Reference
- [WebGPU - W3C Working Draft](https://www.w3.org/TR/webgpu/#intro)
- [WebGPU](https://developer.chrome.com/en/docs/web-platform/webgpu/)

