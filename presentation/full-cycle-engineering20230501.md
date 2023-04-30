---
marp: true
theme: gaia
style: |
  section.center {
      text-align: center;
  }
---

<!-- paginate: true
_backgroundColor: SteelBlue
_color: white
_class: center
-->

<br>
<br>
<br>

# フルサイクル開発とは

May 1, 2023
@chan_naru_way

---

<!--
_backgroundColor: SteelBlue
_color: white
-->

## 目次

1. フルサイクル開発
2. フルサイクル開発の効果
3. フルサイクル開発の課題
4. マイクロサービスとの関係
5. 実例
6. まとめ

---

## 1. フルサイクル開発

開発チームが全ての工程を担当する開発手法

---

![bg left: 50%](https://camo.qiitausercontent.com/a282900f818917e20ec7303754ce68dadfdb2be1/68747470733a2f2f63646e2d696d616765732d312e6d656469756d2e636f6d2f6d61782f3830302f312a732d6c47344a7439745341593044336a5f4e676a57672e706e67)

---

## 2. フルサイクル開発の効果

開発プロセス全体に関与することで

1. **開発アジリティの向上**

2. **コミュニケーション活性化、開発プロセス全体の理解**

3. **各開発フェーズの品質管理が容易に**

---

## 3. フルサイクル開発の課題

1. **幅広いスキルが必要**

2. **各個人の負担増**

3. **導入には組織変更が必要？**

---

### 3.1. 課題〜組織への導入のポイント〜

1. **組織の目的:** フルサイクル開発が組織の目的とビジョンに適合するかを検討する

2. **段階的な導入:** 組織全体を一気に変更するのではなく、段階的に導入していくことでリスクを低減する

3. **サポート体制:** フルサイクル開発の導入には柔軟性が求められるため、メンバーが新しい役割や技術を習得するためのサポートを提供することが重要である

---

### 3.2. 課題〜フルサイクル開発の成功要因〜

1. **チームのスキルセットバランス**

2. **効果的なコミュニケーション:** 問題やアイデアを素早く共有する

3. **自動化とツール:** 重要なプロセスの自動化と、開発や運用に役立つツールの活用

4. **継続的な改善**

---

## 4. マイクロサービスとの組み合わせ

マイクロサービスアーキテクチャ導入により、
チームは機能ごとに編成され、
各チームは他の機能との依存関係を気にせず開発を進められる。

しかし、SRE や QA などの横断チームは、全開発チームの担当が必要で、スケーラビリティに課題がある…

---

![bg](https://camo.qiitausercontent.com/362ec72c1b863c92bf039d8d3a3be277eea785f3/68747470733a2f2f71696974612d696d6167652d73746f72652e73332e61702d6e6f727468656173742d312e616d617a6f6e6177732e636f6d2f302f31343332342f33393739636161382d303939622d613665612d323434632d6631623332666565346265622e706e67)

---

そこで、

各開発チームで SRE や QA などもすべて行うようにする

→ デプロイや QA を待たずにフルサイクルを回すことができる！

---

![bg](https://camo.qiitausercontent.com/d03a10e59153da133c4e419724e19e09903afec4/68747470733a2f2f71696974612d696d6167652d73746f72652e73332e61702d6e6f727468656173742d312e616d617a6f6e6177732e636f6d2f302f31343332342f30616430356334652d626437322d346631302d656362612d3731336138343461303766312e706e67)

---

## 5. 実例

- 株式会社みらい翻訳の例: https://speakerdeck.com/catnapper_mar/lets-start-full-cycle-development?slide=5
- DMM.com の例: https://speakerdeck.com/i35_267/hurusaikuruenziniatoha
- freee の例: https://speakerdeck.com/ogugu9/modern-full-cycle-financial-product-development?slide=3

---

## 5. 実例

- voyagegroup の例: https://speakerdeck.com/hminamiohtsu/developers-summit-2021-summer?slide=3
- mercari の例: https://speakerdeck.com/rilmayer/organizational-essence-to-accelerate-full-cycle-development
- MonotaRO の例: ひみつ

---

## 6. まとめ

フルサイクル開発=**開発チームが全ての工程を担当**する開発手法

- ポイント: **チーム**でフルサイクルを回せること
- デメリット: 開発チームが運用やサポートに関する知識を習得する必要がある

※フルサイクル開発がマッチするかは、組織やプロジェクトの状況によって異なる

チームのスキルセットバランスや効果的なコミュニケーション、自動化とツールの活用、継続的な改善が重要！

---

## Reference

- [Qiita - フルサイクルエンジニアになろう](https://qiita.com/m-chika/items/5e1d6291a53c3cda3371#%E3%83%95%E3%83%AB%E3%82%B5%E3%82%A4%E3%82%AF%E3%83%AB%E3%82%A8%E3%83%B3%E3%82%B8%E3%83%8B%E3%82%A2%E3%83%95%E3%83%AB%E3%82%B5%E3%82%A4%E3%82%AF%E3%83%AB%E9%96%8B%E7%99%BA%E8%80%85%E3%81%A8%E3%81%AF)
- [DMM INSIDER - フルサイクルエンジニアリングを実践する開発組織のオンボーディング設計](https://inside.dmm.com/articles/onboarding-for-full-cycle-developers/)
- 「実例」にリンクしたものたち
