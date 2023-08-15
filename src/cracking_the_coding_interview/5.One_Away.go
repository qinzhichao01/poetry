package cracking_the_coding_interview

import "math"

func oneEditAway(first string, second string) bool {
	diff := len(first) - len(second)
	if math.Abs(float64(diff)) > 1 {
		return false
	}
	if len(first) < len(second) {
		var temp = first
		first = second
		second = temp
	}

	bytes1 := []byte(first)
	bytes2 := []byte(second)
	// 只做一次交换
	if diff == 0 {
		var count = 0
		var i, j = 0
		for idx := range bytes2 {
			if bytes2[idx] != bytes1[idx] {
				count++
			}
		}
	}

	return true
}
