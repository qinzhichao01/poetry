package cracking_the_coding_interview

import "sort"

// CheckPermutation 通过排序后判断是否一样
func CheckPermutation(s1 string, s2 string) bool {
	if len(s1) != len(s2) {
		return false
	}
	bytes1 := []byte(s1)
	bytes2 := []byte(s2)
	sort.Slice(bytes1, func(x1 int, x2 int) bool {
		return bytes1[x1] < bytes1[x2]
	})

	sort.Slice(bytes2, func(x1 int, x2 int) bool {
		return bytes2[x1] < bytes2[x2]
	})
	return string(bytes1) == string(bytes2)
}

// CheckPermutation2 统计每个字符出现的频次
func CheckPermutation2(s1 string, s2 string) bool {
	var c1, c2 [128]int
	for _, ch := range s1 {
		c1[ch]++
	}
	for _, ch := range s2 {
		c2[ch]++
	}
	return c1 == c2
}
