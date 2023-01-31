# About WebGPU

## Reference
- [WebGPU - W3C Working Draft](https://www.w3.org/TR/webgpu/#intro)
- [WebGPU](https://developer.chrome.com/en/docs/web-platform/webgpu/)

## From W3C's docs intro
GPUは、パーソナルコンピュータのレンダリングや計算処理をリッチにするために必要不可欠である。
WebGPUは、GPUハードウェアの機能をWeb上に公開するAPIで、このAPIは、（2014年以降の）ネイティブGPU APIに効率的にマッピングできるよう、ゼロから設計されている。
WebGPUはWebGLとは無関係であり、OpenGL ESを明示的に対象外としている。

WebGPUは物理的なGPUハードウェアをGPUAdaptersとして見る。
リソースを管理するGPUDeviceと、コマンドを実行するデバイスのGPUQueueを介して、アダプタへの接続を提供します。
GPUDeviceはプロセッシングユニットに高速にアクセスできる独自のメモリを持つことができます。
GPUBufferとGPUTextureはGPUメモリに裏打ちされた物理リソースです。
GPUCommandBufferとGPURenderBundleはユーザーが記録したコマンドを格納するコンテナです。
GPUShaderModuleはシェーダーコードを格納します。
GPUSamplerやGPUBindGroupなどの他のリソースは、物理リソースがGPU によって使用される方法を設定します。

GPUはGPUCommandBufferでエンコードされたコマンドを、固定機能段とプログラマブル段が混在するパイプラインを経由してデータを送り込むことで実行します。
プログラマブルステージはGPUハードウェア上で動作するように設計された特別なプログラムであるシェーダを実行します。
パイプラインの状態のほとんどは、GPURenderPipelineまたはGPUComputePipelineオブジェクトによって定義されます。
これらのパイプラインオブジェクトに含まれない状態は、beginRenderPass()やsetBlendConstant()などのコマンドでエンコード中に設定されます。

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
