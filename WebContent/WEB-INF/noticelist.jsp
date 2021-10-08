<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
        <h1 id="title">T.B.H 공지사항</h1>
        <button id="btn1">마이페이지</button>
        <button id="btn2">로그아웃</button>
    </header>
    <ul>
        <li><a href="#">모집</a></li>
        <li><a href="#">중고장터</a></li>
        <li><a href="#">자유게시판</a></li>
        <li><a href="#">공지사항, Q&A</a></li>
    </ul>
    <hr>
    <article>
        <nav>
            <ul>
                <li>공지사항</li>
                <li>Q&A</li>
            </ul>
        </nav>
        <div class="dataTbl1">
            <table>
                <caption>공지사항</caption>

                <colgroup>
                    <col width="10%" />
                    <col width="*" />
                    <col width="14%" />
                </colgroup>

                <thead>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>등록일</th>
                </thead>

                <tbody>
                    <tr>
                        <td>33</td>
                        <td class="article"><a href="#">T.B.H 이용 수칙</a></td>
                        <td>O O O</td>
                        <td>2021-10-21</td>
                    </tr>
                    <tr>
                        <td>32</td>
                        <td class="article"><strong><a href="#">공지사항 2</a></strong></td>
                        <td>O O O</td>
                        <td>2021-10-19</td>
                    </tr>
                    <tr>
                        <td>31</td>
                        <td class="article"><a href="#">공지사항 3</a></td>
                        <td>O O O</td>
                        <td>2021-10-18</td>
                    </tr>
                    <tr>
                        <td>30</td>
                        <td class="article"><a href="#">공지사항 4</a></td>
                        <td>O O O</td>
                        <td>2021-10-18</td>
                    </tr>
                    <tr>
                        <td>29</td>
                        <td class="article"><a href="#">공지사항 5</a></td>
                        <td>O O O</td>
                        <td>2021-10-18</td>
                    </tr>
                    <tr>
                        <td>28</td>
                        <td class="article"><a href="#">공지사항 6</a></td>
                        <td>O O O</td>
                        <td>2021-10-13</td>
                    </tr>
                    <tr>
                        <td>27</td>
                        <td class="article"><a href="#">공지사항 7</a></td>
                        <td>O O O</td>
                        <td>2021-10-12</td>
                    </tr>
                    <tr>
                        <td>26</td>
                        <td class="article"><a href="#">공지사항 8</a></td>
                        <td>O O O</td>
                        <td>2021-10-11</td>
                    </tr>
                    <tr>
                        <td>25</td>
                        <td class="article"><a href="#">공지사항 9</a></td>
                        <td>O O O</td>
                        <td>2021-10-11</td>
                    </tr>
                    <tr>
                        <td>24</td>
                        <td class="article"><a href="#">공지사항 10</a></td>
                        <td>O O O</td>
                        <td>2021-10-10</td>
                    </tr>
                    <tr>
                        <td colspan="4">T.B.H 기본 가이드</td>
                    </tr>
                </tbody>
            </table>
            <div id="handler">
                <button></button>
                <button></button>
                <span><a href="#">1</a></span>
                <span><a href="#">2</a></span>
                <span><a href="#">3</a></span>
                <span><a href="#">4</a></span>
                <span><a href="#">5</a></span>
                <button></button>
                <button></button>
            </div>
        </div>
    </article>
	
	
</body>
</html>