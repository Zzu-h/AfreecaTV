![image](https://w.namu.la/s/621107173c853e80ceecc1a5c6ad004e173c9e1ce021ce0f8a570aa4d8683991ae1c3a770686f400ee15415810cb3a50776db3b1b8b7cb48b9c529e4a6f55736a5a9adecb2de1ceb59689cb94092e0a3894371f9a88ea4c70fac43ecc41ac0db)

# 📱 기능 설명

- 데모 영상

[![Afreeca Thumbnail](https://img.youtube.com/vi/-gX8_5GeRFc/0.jpg)](https://youtu.be/-gX8_5GeRFc)

### 메인 페이지

Home             |  Loading
:-------------------------:|:-------------------------:
![](https://user-images.githubusercontent.com/72387349/211192149-f705351a-fdaf-486b-be91-e3d760db1567.png)  |  ![](https://user-images.githubusercontent.com/72387349/211192083-69c9ae0a-c0d0-487c-95ff-f6eb407a44d4.png)

- 카테고리 API를 사용하여 가져온 카테고리 중 3개 이상의 카테고리를 선정하여 탭을 구성
- 각 탭 클릭 시 그 카테고리에 해당하는 방송 리스트를 보여줌
- 페이징 기능으로 다음 페이지 리스트가 하단에 추가된다.
- 방송 클릭 시 해당 방송의 상세 페이지로 이동

### 상세 페이지
Detail             |  Play
:-------------------------:|:-------------------------:
![](https://user-images.githubusercontent.com/72387349/211192198-3119c83d-0469-44dd-a38e-7e2e79b5c9e3.png)  |  ![](https://user-images.githubusercontent.com/72387349/211192252-20dafe28-df5b-4fda-a1e1-9cf7e39ba113.png)

- 클릭한 해당 방송 정보를 상세히 확인 가능
- 해당 화면에서 방송 시청이 가능

## 🔥 개발 특징

### Project Common Ground
- Multi Module
    - 비교적 프로젝트가 간단한만큼 Monolithic 앱 구조가 더 개발에 있어 효율적일 것이다.
    - 하지만, 이번 기회를 통해 멀티 모듈에 대한 학습과 분리된 모듈에서 각자의 역할을 충실히 할 수 있도록 개발을 하는 것을 목표로 두고 멀티 모듈로 개발하게 되었다.
- buildSrc + Kotlin DSL
    - Multi Mdoule로 개발을 하게 되면서 프로젝트 그래들 관리를 일괄적으로 처리할 필요가 있었다.
    - 기존에 하던 스타일대로 Groovy를 통해 하려던 중 [안드로이드](https://developer.android.com/studio/build/migrate-to-kts)에서 KTS를 권장하고 있었다.
    - Kotlin이 더 익숙하던 내겐 이를 통해 버전관리를 하는 것이 더 효율적이라 판단해 이번 프로젝트에 적용하게 되었다.
- Fragment Transaction
    - Detail화면도 Fragment로 개발하게 되면서 Jetpack navigation 활용을 생각했다.
    - 하지만 Home 화면에서 벗어나 Detail 화면으로 이동한 후 Home 화면으로 다시 돌아오게 되었을 때 Home 화면은 이전 상태를 잃고 새로 모든 것을 생성하게 되었다.
        - jetpack navigation을 활용하게 되면 이전 상태의 fragment를 저장할 수 없음
    - Jetpack Navigation의 한계로 Fragment Transaction을 직접 관리하게 되었다.
- Test Code
    - Data Module의 BroadDataSource가 API 호출을 하고 데이터를 받아오는 만큼 중요한 역할을 맡고 있기에 해당 부분에 Test Code를 작성하게 되었다.
    - MockWebServer를 활용해 정상적으로 동작하는 로직임을 확인할 수 있었다.
- UseCase
    - viewmodel이 Repository를 가지고 직접 원하는 메소드를 호출하게 된다면, viewModel은 자신의 역할이 모호해질 수 있다.
        - viewmodel은 각 화면의 data holder의 역할로 그 역할이 모호해지면 안된다고 생각한다.
    - 각 viewmodel이 자신이 하고자 하는 역할을 명확히 이해하기 위해 UseCase를 작성해 viewModel이 필요한 기능만을 사용할 수 있도록 만들었다.

### Main Page
- TabLayout + ViewPager
    - Category List를 요청하고 받아온 후 임의의 5개의 카테고리 정보를 리스트 프래그먼트로 전달하고 생성한다.
    - 그렇게 생성된 5개의 프래그먼트는 TabLayout과 ViewPager의 결합을 통해 관리되고, 화면에 띄울 수 있다.
    - 하지만, 초기 로드 시에 fragment를 화면에 띄울 때 데이터를 요청하고 생성이 되기에 다소 느림감이 있다.
        - 해당 문제는 HomeFragment가 생성될 때, 즉 ViewPager가 초기화 되고 난 후에 offscreenPageLimit를 설정해 두어 preFetch를 수행하게 한다.
- Paging
    - 페이징 기능을 구현하기 위해 Android Jetpack에서 제공되는 Paging Library를 사용했다.
    - RecyclerView Adapter를 PagingDataAdapter로 구현하고, RecyclerView가 바닥에 닿을 때 즈음 이 라이브러리가 알아서 다음 페이지의 데이터를 요청해준다.
    - [PagingSource의 위치](https://github.com/Zzu-h/AfreecaTV/wiki/Trouble-Shooting#broadpagingsource%EC%9D%98-%EC%9C%84%EC%B9%98)에 대한 고찰을 진행했으며, 해당 링크에 정리해두었다.
    - 다음 페이지가 로드될 때 하단 LinearProgress를 통해 로드되는 상황을 표시한다.

### Detail Page
- Fragment로 구현
    - Home 화면과 매우 다른 화면을 가지고 있기에 Activity로 구현을 생각하고 있었다.
    - 하지만 화면 전환의 애니메이션과 화면들의 상태 관리들을 직접 할 수 있다는 장점에 Fragment를 선택했다.
    - 방송 데이터를 클릭하고 화면이 전환될 때 Detail 화면으로 자연스레 변환되는 것을 확인할 수 있다.
- WebView
    - 해당 화면에서 방송 썸네일을 보여주고 클릭 시 player로 리다이렉션을 생각했다.
    - 하지만 방송을 현재 화면에서 직접 보는 것이 더 적합하다고 판단되어 웹뷰를 활용해 player를 직접 띄우게 되었다.
    - [player 모바일 버전의 오류](https://github.com/Zzu-h/AfreecaTV/wiki/Trouble-Shooting#webview)가 있어 이를 해결하는데 다소 힘들었던 점이 있었다.

<br>

## 📚 Specification

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
    <td rowspan="3"><b> 💻 Dev Environment</b></td>
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

## 📖 Docs

- [백로그](https://docs.google.com/spreadsheets/d/1Eeerz5xdZbg3aArxyEIFLAmZQ_TSlWCDHQVMBTHjeOk/edit?usp=sharing)
- [기술스택](https://github.com/Zzu-h/AfreecaTV/wiki/Skill-Stack)

## 💡 Rule

- [Git 사용법](https://github.com/Zzu-h/AfreecaTV/wiki/Git-%EC%82%AC%EC%9A%A9%EB%B2%95)
- [Coding Convention](https://github.com/Zzu-h/AfreecaTV/wiki/Coding-Convention)

## 🚀 스프린트

- [Sprint 계획](https://github.com/Zzu-h/AfreecaTV/wiki/Sprint-계획)

## 🧑‍💻 고민했던 내용

- [Trouble Shooting](https://github.com/Zzu-h/AfreecaTV/wiki/Trouble-Shooting)