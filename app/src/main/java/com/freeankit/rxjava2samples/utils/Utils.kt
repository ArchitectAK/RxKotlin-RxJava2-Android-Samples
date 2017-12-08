package com.freeankit.rxjava2samples.utils

import com.freeankit.rxjava2samples.model.GithubUser
import com.freeankit.rxjava2samples.model.User
import java.util.ArrayList

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 08/12/2017 (MM/DD/YYYY )
 */
class Utils {
    fun convertApiUserListToUserList(githubUserList: List<GithubUser>): List<User> {
        val userList = ArrayList<User>()

        for (apiUser in githubUserList) {
            val user = User()
            user.login = apiUser.login
            user.url = apiUser.url
            userList.add(user)
        }

        return userList
    }

    fun getApiUserList(): List<GithubUser> {
        val apiUserList = ArrayList<GithubUser>()

        val apiUserOne = GithubUser("Ankit", 1, "Kumar")
        apiUserList.add(apiUserOne)

        val apiUserTwo = GithubUser("JP", 2, "Kumar")
        apiUserList.add(apiUserTwo)

        val apiUserThree = GithubUser("Ankit", 3, "Prajapati")
        apiUserList.add(apiUserThree)

        return apiUserList
    }
}