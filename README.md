![image](https://w.namu.la/s/621107173c853e80ceecc1a5c6ad004e173c9e1ce021ce0f8a570aa4d8683991ae1c3a770686f400ee15415810cb3a50776db3b1b8b7cb48b9c529e4a6f55736a5a9adecb2de1ceb59689cb94092e0a3894371f9a88ea4c70fac43ecc41ac0db)

# ๐ฑ ๊ธฐ๋ฅ ์ค๋ช

- ๋ฐ๋ชจ ์์

[![Afreeca Thumbnail](https://img.youtube.com/vi/-gX8_5GeRFc/0.jpg)](https://youtu.be/-gX8_5GeRFc)

### ๋ฉ์ธ ํ์ด์ง

Home             |  Loading
:-------------------------:|:-------------------------:
![](https://user-images.githubusercontent.com/72387349/211192149-f705351a-fdaf-486b-be91-e3d760db1567.png)  |  ![](https://user-images.githubusercontent.com/72387349/211192083-69c9ae0a-c0d0-487c-95ff-f6eb407a44d4.png)

- ์นดํ๊ณ ๋ฆฌ API๋ฅผ ์ฌ์ฉํ์ฌ ๊ฐ์ ธ์จ ์นดํ๊ณ ๋ฆฌ ์ค 3๊ฐ ์ด์์ ์นดํ๊ณ ๋ฆฌ๋ฅผ ์ ์ ํ์ฌ ํญ์ ๊ตฌ์ฑ
- ๊ฐ ํญ ํด๋ฆญ ์ ๊ทธ ์นดํ๊ณ ๋ฆฌ์ ํด๋นํ๋ ๋ฐฉ์ก ๋ฆฌ์คํธ๋ฅผ ๋ณด์ฌ์ค
- ํ์ด์ง ๊ธฐ๋ฅ์ผ๋ก ๋ค์ ํ์ด์ง ๋ฆฌ์คํธ๊ฐ ํ๋จ์ ์ถ๊ฐ๋๋ค.
- ๋ฐฉ์ก ํด๋ฆญ ์ ํด๋น ๋ฐฉ์ก์ ์์ธ ํ์ด์ง๋ก ์ด๋

### ์์ธ ํ์ด์ง
Detail             |  Play
:-------------------------:|:-------------------------:
![](https://user-images.githubusercontent.com/72387349/211192198-3119c83d-0469-44dd-a38e-7e2e79b5c9e3.png)  |  ![](https://user-images.githubusercontent.com/72387349/211192252-20dafe28-df5b-4fda-a1e1-9cf7e39ba113.png)

- ํด๋ฆญํ ํด๋น ๋ฐฉ์ก ์ ๋ณด๋ฅผ ์์ธํ ํ์ธ ๊ฐ๋ฅ
- ํด๋น ํ๋ฉด์์ ๋ฐฉ์ก ์์ฒญ์ด ๊ฐ๋ฅ

## ๐ฅ ๊ฐ๋ฐ ํน์ง

### Project Common Ground
- Multi Module
    - ๋น๊ต์  ํ๋ก์ ํธ๊ฐ ๊ฐ๋จํ๋งํผ Monolithic ์ฑ ๊ตฌ์กฐ๊ฐ ๋ ๊ฐ๋ฐ์ ์์ด ํจ์จ์ ์ผ ๊ฒ์ด๋ค.
    - ํ์ง๋ง, ์ด๋ฒ ๊ธฐํ๋ฅผ ํตํด ๋ฉํฐ ๋ชจ๋์ ๋ํ ํ์ต๊ณผ ๋ถ๋ฆฌ๋ ๋ชจ๋์์ ๊ฐ์์ ์ญํ ์ ์ถฉ์คํ ํ  ์ ์๋๋ก ๊ฐ๋ฐ์ ํ๋ ๊ฒ์ ๋ชฉํ๋ก ๋๊ณ  ๋ฉํฐ ๋ชจ๋๋ก ๊ฐ๋ฐํ๊ฒ ๋์๋ค.
- buildSrc + Kotlin DSL
    - Multi Mdoule๋ก ๊ฐ๋ฐ์ ํ๊ฒ ๋๋ฉด์ ํ๋ก์ ํธ ๊ทธ๋๋ค ๊ด๋ฆฌ๋ฅผ ์ผ๊ด์ ์ผ๋ก ์ฒ๋ฆฌํ  ํ์๊ฐ ์์๋ค.
    - ๊ธฐ์กด์ ํ๋ ์คํ์ผ๋๋ก Groovy๋ฅผ ํตํด ํ๋ ค๋ ์ค [์๋๋ก์ด๋](https://developer.android.com/studio/build/migrate-to-kts)์์ KTS๋ฅผ ๊ถ์ฅํ๊ณ  ์์๋ค.
    - Kotlin์ด ๋ ์ต์ํ๋ ๋ด๊ฒ ์ด๋ฅผ ํตํด ๋ฒ์ ๊ด๋ฆฌ๋ฅผ ํ๋ ๊ฒ์ด ๋ ํจ์จ์ ์ด๋ผ ํ๋จํด ์ด๋ฒ ํ๋ก์ ํธ์ ์ ์ฉํ๊ฒ ๋์๋ค.
- Fragment Transaction
    - Detailํ๋ฉด๋ Fragment๋ก ๊ฐ๋ฐํ๊ฒ ๋๋ฉด์ Jetpack navigation ํ์ฉ์ ์๊ฐํ๋ค.
    - ํ์ง๋ง Home ํ๋ฉด์์ ๋ฒ์ด๋ Detail ํ๋ฉด์ผ๋ก ์ด๋ํ ํ Home ํ๋ฉด์ผ๋ก ๋ค์ ๋์์ค๊ฒ ๋์์ ๋ Home ํ๋ฉด์ ์ด์  ์ํ๋ฅผ ์๊ณ  ์๋ก ๋ชจ๋  ๊ฒ์ ์์ฑํ๊ฒ ๋์๋ค.
        - jetpack navigation์ ํ์ฉํ๊ฒ ๋๋ฉด ์ด์  ์ํ์ fragment๋ฅผ ์ ์ฅํ  ์ ์์
    - Jetpack Navigation์ ํ๊ณ๋ก Fragment Transaction์ ์ง์  ๊ด๋ฆฌํ๊ฒ ๋์๋ค.
- Test Code
    - Data Module์ BroadDataSource๊ฐ API ํธ์ถ์ ํ๊ณ  ๋ฐ์ดํฐ๋ฅผ ๋ฐ์์ค๋ ๋งํผ ์ค์ํ ์ญํ ์ ๋งก๊ณ  ์๊ธฐ์ ํด๋น ๋ถ๋ถ์ Test Code๋ฅผ ์์ฑํ๊ฒ ๋์๋ค.
    - MockWebServer๋ฅผ ํ์ฉํด ์ ์์ ์ผ๋ก ๋์ํ๋ ๋ก์ง์์ ํ์ธํ  ์ ์์๋ค.
- UseCase
    - viewmodel์ด Repository๋ฅผ ๊ฐ์ง๊ณ  ์ง์  ์ํ๋ ๋ฉ์๋๋ฅผ ํธ์ถํ๊ฒ ๋๋ค๋ฉด, viewModel์ ์์ ์ ์ญํ ์ด ๋ชจํธํด์ง ์ ์๋ค.
        - viewmodel์ ๊ฐ ํ๋ฉด์ data holder์ ์ญํ ๋ก ๊ทธ ์ญํ ์ด ๋ชจํธํด์ง๋ฉด ์๋๋ค๊ณ  ์๊ฐํ๋ค.
    - ๊ฐ viewmodel์ด ์์ ์ด ํ๊ณ ์ ํ๋ ์ญํ ์ ๋ชํํ ์ดํดํ๊ธฐ ์ํด UseCase๋ฅผ ์์ฑํด viewModel์ด ํ์ํ ๊ธฐ๋ฅ๋ง์ ์ฌ์ฉํ  ์ ์๋๋ก ๋ง๋ค์๋ค.

### Main Page
- TabLayout + ViewPager
    - Category List๋ฅผ ์์ฒญํ๊ณ  ๋ฐ์์จ ํ ์์์ 5๊ฐ์ ์นดํ๊ณ ๋ฆฌ ์ ๋ณด๋ฅผ ๋ฆฌ์คํธ ํ๋๊ทธ๋จผํธ๋ก ์ ๋ฌํ๊ณ  ์์ฑํ๋ค.
    - ๊ทธ๋ ๊ฒ ์์ฑ๋ 5๊ฐ์ ํ๋๊ทธ๋จผํธ๋ TabLayout๊ณผ ViewPager์ ๊ฒฐํฉ์ ํตํด ๊ด๋ฆฌ๋๊ณ , ํ๋ฉด์ ๋์ธ ์ ์๋ค.
    - ํ์ง๋ง, ์ด๊ธฐ ๋ก๋ ์์ fragment๋ฅผ ํ๋ฉด์ ๋์ธ ๋ ๋ฐ์ดํฐ๋ฅผ ์์ฒญํ๊ณ  ์์ฑ์ด ๋๊ธฐ์ ๋ค์ ๋๋ฆผ๊ฐ์ด ์๋ค.
        - ํด๋น ๋ฌธ์ ๋ HomeFragment๊ฐ ์์ฑ๋  ๋, ์ฆ ViewPager๊ฐ ์ด๊ธฐํ ๋๊ณ  ๋ ํ์ offscreenPageLimit๋ฅผ ์ค์ ํด ๋์ด preFetch๋ฅผ ์ํํ๊ฒ ํ๋ค.
- Paging
    - ํ์ด์ง ๊ธฐ๋ฅ์ ๊ตฌํํ๊ธฐ ์ํด Android Jetpack์์ ์ ๊ณต๋๋ Paging Library๋ฅผ ์ฌ์ฉํ๋ค.
    - RecyclerView Adapter๋ฅผ PagingDataAdapter๋ก ๊ตฌํํ๊ณ , RecyclerView๊ฐ ๋ฐ๋ฅ์ ๋ฟ์ ๋ ์ฆ์ ์ด ๋ผ์ด๋ธ๋ฌ๋ฆฌ๊ฐ ์์์ ๋ค์ ํ์ด์ง์ ๋ฐ์ดํฐ๋ฅผ ์์ฒญํด์ค๋ค.
    - [PagingSource์ ์์น](https://github.com/Zzu-h/AfreecaTV/wiki/Trouble-Shooting#broadpagingsource%EC%9D%98-%EC%9C%84%EC%B9%98)์ ๋ํ ๊ณ ์ฐฐ์ ์งํํ์ผ๋ฉฐ, ํด๋น ๋งํฌ์ ์ ๋ฆฌํด๋์๋ค.
    - ๋ค์ ํ์ด์ง๊ฐ ๋ก๋๋  ๋ ํ๋จ LinearProgress๋ฅผ ํตํด ๋ก๋๋๋ ์ํฉ์ ํ์ํ๋ค.

### Detail Page
- Fragment๋ก ๊ตฌํ
    - Home ํ๋ฉด๊ณผ ๋งค์ฐ ๋ค๋ฅธ ํ๋ฉด์ ๊ฐ์ง๊ณ  ์๊ธฐ์ Activity๋ก ๊ตฌํ์ ์๊ฐํ๊ณ  ์์๋ค.
    - ํ์ง๋ง ํ๋ฉด ์ ํ์ ์ ๋๋ฉ์ด์๊ณผ ํ๋ฉด๋ค์ ์ํ ๊ด๋ฆฌ๋ค์ ์ง์  ํ  ์ ์๋ค๋ ์ฅ์ ์ Fragment๋ฅผ ์ ํํ๋ค.
    - ๋ฐฉ์ก ๋ฐ์ดํฐ๋ฅผ ํด๋ฆญํ๊ณ  ํ๋ฉด์ด ์ ํ๋  ๋ Detail ํ๋ฉด์ผ๋ก ์์ฐ์ค๋  ๋ณํ๋๋ ๊ฒ์ ํ์ธํ  ์ ์๋ค.
- WebView
    - ํด๋น ํ๋ฉด์์ ๋ฐฉ์ก ์ธ๋ค์ผ์ ๋ณด์ฌ์ฃผ๊ณ  ํด๋ฆญ ์ player๋ก ๋ฆฌ๋ค์ด๋ ์์ ์๊ฐํ๋ค.
    - ํ์ง๋ง ๋ฐฉ์ก์ ํ์ฌ ํ๋ฉด์์ ์ง์  ๋ณด๋ ๊ฒ์ด ๋ ์ ํฉํ๋ค๊ณ  ํ๋จ๋์ด ์น๋ทฐ๋ฅผ ํ์ฉํด player๋ฅผ ์ง์  ๋์ฐ๊ฒ ๋์๋ค.
    - [player ๋ชจ๋ฐ์ผ ๋ฒ์ ์ ์ค๋ฅ](https://github.com/Zzu-h/AfreecaTV/wiki/Trouble-Shooting#webview)๊ฐ ์์ด ์ด๋ฅผ ํด๊ฒฐํ๋๋ฐ ๋ค์ ํ๋ค์๋ ์ ์ด ์์๋ค.

<br>

## ๐ Specification

<table class="tg">
<tbody>
  <tr>
    <td><b>Architecture</b></td>
    <td>MVVM</td>
  </tr>
<tr>
    <td><b>Design Pattern</b></td>
<td>Repository Pattern, Delegation Pattern</td>
</tr>
<tr>
    <td><b>Jetpack Components</b></td>
<td>DataBinding, Flow, ViewModel, RecyclerView, Lifecycle, ViewPager2, Paging3</td>
</tr>
<tr>
    <td><b>Dependency Injection</b></td>
<td>Hilt</td>
</tr>
<tr>
    <td><b>Network</b></td>
<td>OkHttp3, Retrofit2, Gson</td>
</tr>
<tr>
    <td><b>Unit Test</b></td>
<td>junit, Coroutine, MockWebServer</td>
</tr>
<tr>
    <td><b>Asynchronous Processing</b></td>
<td>Coroutine</td>
</tr>
<tr>
    <td><b>Third Party Library</b></td>
    <td>Coil</td>

</tr>
<tr>
    <td><b>Strategy</b></td>
<td>Git Flow</td>
</tr>
<tr>
    <td><b>Other Tool</b></td>
<td>Notion, Git Wiki</td>
</tr>
<tr>
    <td rowspan="3"><b> ๐ป Dev Environment</b></td>
<td>Language : Kotlin</td>
<tr>
<td>minSdk : 23</td>
</td>
<tr>
<td>targetSdk : 31</td>
</tr>
</tbody>
</table>

<br>

## ๐ Docs

- [๋ฐฑ๋ก๊ทธ](https://docs.google.com/spreadsheets/d/1Eeerz5xdZbg3aArxyEIFLAmZQ_TSlWCDHQVMBTHjeOk/edit?usp=sharing)
- [๊ธฐ์ ์คํ](https://github.com/Zzu-h/AfreecaTV/wiki/Skill-Stack)

## ๐ก Rule

- [Git ์ฌ์ฉ๋ฒ](https://github.com/Zzu-h/AfreecaTV/wiki/Git-%EC%82%AC%EC%9A%A9%EB%B2%95)
- [Coding Convention](https://github.com/Zzu-h/AfreecaTV/wiki/Coding-Convention)

## ๐ ์คํ๋ฆฐํธ

- [Sprint ๊ณํ](https://github.com/Zzu-h/AfreecaTV/wiki/Sprint-๊ณํ)

## ๐งโ๐ป ๊ณ ๋ฏผํ๋ ๋ด์ฉ

- [Trouble Shooting](https://github.com/Zzu-h/AfreecaTV/wiki/Trouble-Shooting)